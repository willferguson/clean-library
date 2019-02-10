package xyz.willferguson.library.domain.entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

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
     * Determines whether the Library will allow the borrower to borrow the book.
     * Different libraries have different rules - thus it is the responsibility of the library to determine.
     *
     * @param borrower
     * @param book
     * @return
     */
    public boolean canBorrow(Person borrower, Book book) {
        return true;
    }


}

