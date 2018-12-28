package xyz.willferguson.library.domain.exceptions;

public class InvaidOperationException extends RuntimeException {

    public InvaidOperationException(String message) {
        super(message);
    }

    public InvaidOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvaidOperationException(Throwable cause) {
        super(cause);
    }
}
