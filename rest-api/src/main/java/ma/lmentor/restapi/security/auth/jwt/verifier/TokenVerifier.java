package ma.lmentor.restapi.security.auth.jwt.verifier;

public interface TokenVerifier {
    boolean verify(String jti);
}
