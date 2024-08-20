package api.spotify.exception;

public class AuthException extends RuntimeException {

    public AuthException(String message) {
        super(String.format("%s", message));
    }
}