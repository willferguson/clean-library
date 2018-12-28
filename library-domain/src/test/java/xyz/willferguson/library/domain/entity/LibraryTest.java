package xyz.willferguson.library.domain.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void calculateFine() {
        Library library = new Library(BigDecimal.TEN);
        BigDecimal fine = library.calculateFine(Instant.now().minus(Duration.ofDays(3)));
        assertEquals(BigDecimal.valueOf(30), fine, "Fine should be 30");
    }
}