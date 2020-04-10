package ma.lmentor.restapi.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        var header = request.getHeader(SecurityConstants.AUTHORIZATION_HEADER_KEY);

        if (header != null && header.startsWith(SecurityConstants.JWT_TOKEN_PREFIX)) {
            var authenticationToken = getAuthenticationToken(request);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
        var token = request.getHeader(SecurityConstants.AUTHORIZATION_HEADER_KEY);
        var user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_SIGNATURE))
                .build()
                .verify(token.replace(SecurityConstants.JWT_TOKEN_PREFIX, ""))
                .getSubject();

        return user == null ? null : new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
    }
}
