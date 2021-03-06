package xyz.willferguson.library.domain.entity;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

//TODO Consider equals method - is it id, or isbn?
public class Book implements Identifiable {

    private final UUID id;
    private final String isbn13;
    private final String title;
    private final String author;
    private Duration loanDuration;
    private LoanStatus loanStatus;


    public Book(String isbn13, String title, String author) {
        this(isbn13, title, author, Duration.ofDays(30), LoanStatus.AVAILABLE);
    }


    public Book(String isbn13, String title, String author, Duration loanDuration, LoanStatus loanStatus) {
        this.id = UUID.randomUUID();
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
        this.loanDuration = loanDuration;
        this.loanStatus = loanStatus;
    }

    public UUID getId() {
        return id;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Duration getLoanDuration() {
        return loanDuration;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }


    public void updateLoanDuration(Duration newDuration) {
        this.loanDuration = newDuration;
    }

    public Instant getReturnDate() {
        return Instant.now().plus(this.loanDuration);
    }

    public boolean isAvailable() {
        return loanStatus == LoanStatus.AVAILABLE;
    }

    public Loan borrow(UUID borrowerId) {
        this.loanStatus = LoanStatus.ON_LOAN;
        return new Loan(borrowerId, this.id, this.getReturnDate());
    }

    public void returnBook() {
        this.loanStatus = LoanStatus.AVAILABLE;
    }
}
