package xyz.willferguson.library.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import xyz.willferguson.library.domain.exceptions.BookNotAvailableException;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.UUID;

public class BookTest {

//    @DisplayName("Create loan when book available")
//    @Test
//    void TestCreateLoanWhenBookAvailable() throws Exception {
//        Book book = new Book("isbn", "title", "author", Duration.ofDays(30), LoanStatus.AVAILABLE);
//        Loan loan = book.createLoan(UUID.randomUUID());
//        assertNotNull(loan, "Loan is null");
//    }
//
//    @DisplayName("Create loan when book not available")
//    @Test
//
//    void TestCreateLoanWhenBookNotAvailable() {
//        Book book = new Book("isbn", "title", "author", Duration.ofDays(30), LoanStatus.ON_LOAN);
//        assertThrows(BookNotAvailableException.class, () -> book.createLoan(UUID.randomUUID()));
//
//    }
}
