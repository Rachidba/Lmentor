package ma.lmentor.restapi.exceptions;

public class MandatoryInputsException extends RuntimeException {
    private String message;

    public MandatoryInputsException(String message) {
        this.message = message;
    }
}
