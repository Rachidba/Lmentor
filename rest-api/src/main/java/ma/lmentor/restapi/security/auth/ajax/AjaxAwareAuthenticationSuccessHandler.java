package ma.lmentor.restapi.security.auth.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.security.model.UserContext;
import ma.lmentor.restapi.security.model.token.JwtToken;
import ma.lmentor.restapi.security.model.token.JwtTokenFactory;
import ma.lmentor.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AjaxAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final ObjectMapper mapper;
    private final JwtTokenFactory tokenFactory;
    private final UserService userService;

    @Autowired
    public AjaxAwareAuthenticationSuccessHandler(
            final ObjectMapper mapper,
            final JwtTokenFactory tokenFactory,
            final UserService userService) {
        this.mapper = mapper;
        this.tokenFactory = tokenFactory;
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        UserContext userContext = (UserContext) authentication.getPrincipal();
        User currentUser = userService.get(userContext.getUsername()).get();

        if(currentUser.isEnabled()) {
            JwtToken accessToken = tokenFactory.createAccessJwtToken(userContext);
            JwtToken refreshToken = tokenFactory.createRefreshToken(userContext);

            Map<String, String> tokenMap = new HashMap<String, String>();
            tokenMap.put("token", accessToken.getToken());
            tokenMap.put("refreshToken", refreshToken.getToken());
            tokenMap.put("isProfileCompleted", String.valueOf(currentUser.getProfile().isProfileCompleted()));
            tokenMap.put("profileId", String.valueOf(currentUser.getProfile().getProfileId()));

            response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            mapper.writeValue(response.getWriter(), tokenMap);
        } else {
            response.setStatus(HttpStatus.LOCKED.value());
        }

        clearAuthenticationAttributes(request);
    }

    /**
     * Removes temporary authentication-related data which may have been stored
     * in the session during the authentication process..
     * 
     */
    protected final void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
