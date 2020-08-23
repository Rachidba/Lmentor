package ma.lmentor.restapi.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.vo.LoginVo;
import ma.lmentor.restapi.models.LoginResponse;
import ma.lmentor.restapi.models.MentorLoginResponse;
import ma.lmentor.restapi.models.RoleType;
import ma.lmentor.restapi.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final ObjectMapper objectMapper;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService, ObjectMapper objectMapper) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.objectMapper = objectMapper;
        setFilterProcessesUrl(SecurityConstants.LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                               HttpServletResponse response)  throws AuthenticationException {
        try {
            var credentials = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginVo.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getEmail(),
                            credentials.getPassword(),
                            new ArrayList<>()
                    )
            );
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public void successfulAuthentication(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain chain,
                                        Authentication auth) throws IOException, ServletException {
        var currentUsername = ((UserDetails)auth.getPrincipal()).getUsername();
        var jwToken = createJwToken(currentUsername);

        var currentUser = userService.get(currentUsername);

        // TODO: Update exception
        if (currentUser.isEmpty()) {
            throw new Exception();
        }
        LoginResponse loginResponse = getLoginResponse(jwToken, currentUser);
        addHeaders(response, jwToken);
        addBody(response, loginResponse);
    }

    private LoginResponse getLoginResponse(String jwToken, Optional<User> currentUser) {
        LoginResponse loginResponse;
        var currentUserProfile = currentUser.get().getProfile();
        switch (currentUser.get().getRole()) {
            case ROLE_MENTOR:
                loginResponse = new MentorLoginResponse(
                        currentUserProfile.getProfileId(),
                        currentUserProfile.getFirstName() + " " + currentUserProfile.getLastName(),
                        jwToken,
                        gerTokenExpiryDateMillis(),
                        currentUser.get().getEmail(),
                        RoleType.ROLE_MENTOR,
                        (currentUserProfile).isProfileCompleted());
                break;
            case ROLE_STUDENT:
                loginResponse = new LoginResponse(
                        currentUserProfile.getProfileId(),
                        currentUserProfile.getFirstName() + " " + currentUserProfile.getLastName(),
                        jwToken,
                        gerTokenExpiryDateMillis(),
                        currentUser.get().getEmail(),
                        RoleType.ROLE_STUDENT,
                        currentUserProfile.isProfileCompleted());
                break;
            default:
                loginResponse = new LoginResponse();
        }
        return loginResponse;
    }

    private void addBody(HttpServletResponse response, LoginResponse loginResponse) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        var loginResponseJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(loginResponse);
        out.print(loginResponseJson);
        out.flush();
    }

    private void addHeaders(HttpServletResponse response, String jwToken) {
        response.addHeader(SecurityConstants.AUTHORIZATION_HEADER_KEY, jwToken);
        response.addHeader(SecurityConstants.EXPIRES_AT_HEADER_KEY, String.valueOf(gerTokenExpiryDateMillis()));
        response.addHeader("Access-Control-Expose-Headers", SecurityConstants.AUTHORIZATION_HEADER_KEY);
        response.addHeader("Access-Control-Expose-Headers", SecurityConstants.EXPIRES_AT_HEADER_KEY);
    }

    private String createJwToken(String currentUsername) {
        return SecurityConstants.JWT_TOKEN_PREFIX
                + JWT.create()
                    .withSubject(currentUsername)
                    .withExpiresAt(new Date(gerTokenExpiryDateMillis()))
                    .sign(HMAC512(SecurityConstants.SECRET_SIGNATURE.getBytes()));
    }

    private long gerTokenExpiryDateMillis() {
        return System.currentTimeMillis() + SecurityConstants.TOKEN_TTL;
    }
}
