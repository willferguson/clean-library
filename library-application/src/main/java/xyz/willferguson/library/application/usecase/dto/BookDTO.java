package xyz.willferguson.library.application.usecase.dto;

import xyz.willferguson.library.domain.entity.LoanStatus;

import java.time.Duration;
import java.util.UUID;

public class BookDTO {

    private UUID id;
    private String isbn13;
    private String title;
    private String author;
    private Duration loanDuration;
    private LoanStatus loanStatus;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Duration getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(Duration loanDuration) {
        this.loanDuration = loanDuration;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
