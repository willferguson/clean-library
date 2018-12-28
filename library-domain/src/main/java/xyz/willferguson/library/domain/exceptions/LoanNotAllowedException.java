package xyz.willferguson.library.domain.exceptions;

public class LoanNotAllowedException extends RuntimeException {

    public LoanNotAllowedException(String message) {
        super(message);
    }

    public LoanNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoanNotAllowedException(Throwable cause) {
        super(cause);
    }
}
