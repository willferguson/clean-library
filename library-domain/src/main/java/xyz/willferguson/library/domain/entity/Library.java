package xyz.willferguson.library.domain.entity;

import xyz.willferguson.library.domain.exceptions.BookNotAvailableException;
import xyz.willferguson.library.domain.exceptions.LoanNotAllowedException;

import javax.swing.plaf.BorderUIResource;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class Library {

    private BigDecimal dailyFine;

    public Library(BigDecimal dailyFine) {
        this.dailyFine = dailyFine;
    }

    public BigDecimal getDailyFine() {
        return dailyFine;
    }

    public BigDecimal calculateFine(Instant returnDate) {
        Duration lateDuration = Duration.between(returnDate, Instant.now());
        return dailyFine.multiply(BigDecimal.valueOf(lateDuration.toDays()));
    }

    /**
     * Checks the book is available, calculates the return date, and returns a Loan.
     * TODO - This doesn't feel right. How can we surface why we can't borrow, into a more expressive & testable structure.
     * @param borrower
     * @param book
     * @return
     */
    public Loan borrowBook(Person borrower, Book book) throws BookNotAvailableException, LoanNotAllowedException {
        if (!book.isAvailable()) throw new BookNotAvailableException(book.getTitle() + " not available");
        if (!canBorrow(borrower)) throw new LoanNotAllowedException("Loan not allowed");
        //TODO We're not setting the book to be ON_LOAN!
        return new Loan(borrower.getUuid(), book.getUuid(), book.getReturnDate());
    }

    private boolean canBorrow(Person borrower) {
        return true;
    }


}
