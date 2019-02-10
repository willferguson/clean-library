package xyz.willferguson.library.domain.entity;

import java.time.Instant;
import java.util.UUID;

public class Loan implements Identifiable {

    private UUID id;
    private UUID borrowerId;
    private UUID bookId;
    private Instant returnDate;

    public Loan(UUID borrowerId, UUID bookId, Instant returnDate) {
        this.id = UUID.randomUUID();
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.returnDate = returnDate;
    }

    public UUID getId() {
        return id;
    }

    public UUID getBorrowerId() {
        return borrowerId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public Instant getReturnDate() {
        return returnDate;
    }

    public boolean isLate() {
        return returnDate.isBefore(Instant.now());
    }
}
