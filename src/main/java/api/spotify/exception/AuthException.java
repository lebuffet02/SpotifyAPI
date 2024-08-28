package api.spotify.exception;

public class AuthException extends RuntimeException {

    public AuthException(String message) {
        super(String.format("%s", message));
    }

    public AuthException(Throwable e) {
        super(String.format("%s" , "Status code: ".concat(e.getMessage())));
    }
}