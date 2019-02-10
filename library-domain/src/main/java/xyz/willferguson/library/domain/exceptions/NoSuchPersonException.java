package xyz.willferguson.library.domain.exceptions;

public class NoSuchPersonException extends Exception {
    public NoSuchPersonException() {
        super();
    }

    public NoSuchPersonException(String message) {
        super(message);
    }

    public NoSuchPersonException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchPersonException(Throwable cause) {
        super(cause);
    }
}
