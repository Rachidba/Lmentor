package ma.lmentor.restapi.security.auth.jwt.extractor;

public interface TokenExtractor {
    String extract(String payload);
}
