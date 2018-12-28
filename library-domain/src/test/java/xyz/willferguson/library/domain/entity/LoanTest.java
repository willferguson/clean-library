package xyz.willferguson.library.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    @DisplayName("Loan is one day late")
    @Test
    void loanIsOneDayLate() {

        Loan loan = new Loan(UUID.randomUUID(), UUID.randomUUID(), Instant.now().minus(Duration.ofDays(1)));
        assertTrue(loan.isLate(), "Loan should be late");
    }

    @DisplayName("Loan is not late")
    @Test
    void loanIsNotLate() {

        Loan loan = new Loan(UUID.randomUUID(), UUID.randomUUID(), Instant.now().plus(Duration.ofDays(1)));
        assertTrue(!loan.isLate(), "Loan should not be late");
    }
}