package ma.lmentor.restapi.security.config;

public class SecurityConstants {
    public static final String REGISTER_URL = "/api/auth/register";
    public static final String CATEGORIES_URL = "/api/categories";
    public static final String SUBCATEGORIES_URL = "/api/subcategories";
    public static final String MENTORS_URL = "/api/mentors/**";
    public static final String AUTHENTICATION_HEADER_NAME = "Authorization";
    public static final String AUTHENTICATION_URL = "/api/auth/login";
    public static final String REFRESH_TOKEN_URL = "/api/auth/token";
    public static final String API_ROOT_URL = "/api/**";
}
