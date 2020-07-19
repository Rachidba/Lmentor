package ma.lmentor.restapi.security;

public class SecurityConstants {
    public static final long TOKEN_TTL = 864_000_000; // 10 days
    public static final String SECRET_SIGNATURE = "lmentor_145236452";
    public static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    public static final String JWT_TOKEN_PREFIX = "Bearer ";
    public static final String REGISTER_URL = "/api/register";
    public static final String LOGIN_URL = "/api/login";
    public static final String EXPIRES_AT_HEADER_KEY = "expiresAt";
}
