package ma.lmentor.restapi.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.lmentor.restapi.models.LoginDto;
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
                    .readValue(request.getInputStream(), LoginDto.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getUsername(),
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

    @Override
    public void successfulAuthentication(HttpServletRequest request,
                                         HttpServletResponse response,
                                         FilterChain chain,
                                         Authentication auth) throws IOException, ServletException {
        var currentUsername = ((UserDetails)auth.getPrincipal()).getUsername();
        var jwtToken = JWT.create()
                .withSubject(currentUsername)
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.TOKEN_TTL))
                .sign(HMAC512(SecurityConstants.SECRET_SIGNATURE.getBytes()));
        response.addHeader(SecurityConstants.AUTHORIZATION_HEADER_KEY, SecurityConstants.JWT_TOKEN_PREFIX + jwtToken);
        response.addHeader(SecurityConstants.EXPIRES_AT_HEADER_KEY, String.valueOf(System.currentTimeMillis() + SecurityConstants.TOKEN_TTL));
        response.addHeader("Access-Control-Expose-Headers", SecurityConstants.AUTHORIZATION_HEADER_KEY);
        response.addHeader("Access-Control-Expose-Headers", SecurityConstants.EXPIRES_AT_HEADER_KEY);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        var currentUserProfile = userService.get(currentUsername).isEmpty() ? null : userService.get(currentUsername).get().getProfile();
        var currentUserProfileAsJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(currentUsername);
        out.print(currentUserProfileAsJson);
        out.flush();
    }
}
