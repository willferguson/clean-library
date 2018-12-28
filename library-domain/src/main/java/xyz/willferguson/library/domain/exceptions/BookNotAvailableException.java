package xyz.willferguson.library.domain.exceptions;

public class BookNotAvailableException extends Exception {

    public BookNotAvailableException(String message) {
        super(message);
    }

    public BookNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotAvailableException(Throwable cause) {
        super(cause);
    }
}
