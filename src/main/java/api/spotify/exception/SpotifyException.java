package api.spotify.exception;

public class SpotifyException extends RuntimeException {

    public SpotifyException(String message) {
        super(String.format("%s", message));
    }
}
