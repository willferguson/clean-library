package xyz.willferguson.library.domain.entity;

import java.time.Instant;
import java.util.UUID;

public class Loan {

    private UUID uuid;
    private UUID borrowerId;
    private UUID bookId;
    private Instant returnDate;

    public Loan(UUID borrowerId, UUID bookId, Instant returnDate) {
        this.uuid = UUID.randomUUID();
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.returnDate = returnDate;
    }

    public UUID getUuid() {
        return uuid;
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
