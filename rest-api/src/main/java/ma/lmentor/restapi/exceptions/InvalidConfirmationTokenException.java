package ma.lmentor.restapi.exceptions;

public class InvalidConfirmationTokenException extends RuntimeException {
    public String message;

    public InvalidConfirmationTokenException(String message) {
        this.message = message;
    }
}
