package ma.lmentor.restapi.security;

public class SecurityConstants {
    public static final long TOKEN_TTL = 864_000_000; // 10 days
    public static final String SECRET_SIGNATURE = "lmentor_145236452";
    public static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    public static final String JWT_TOKEN_PREFIX = "Bearer ";
    public static final String REGISTER_URL = "/api/v1/register";
    public static final String LOGIN_URL = "/api/v1/login";
    public static final String DOCUMENTATION_URL = "/swagger-ui.html";
    public static final String EXPIRES_AT_HEADER_KEY = "expiresAt";
    public static final String CATEGORIES_URL = "/api/v1/categories";
    public static final String SUBCATEGORIES_URL = "/api/v1/subcategories";
}
