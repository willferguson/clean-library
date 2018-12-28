package xyz.willferguson.library.application.usecase;

import xyz.willferguson.library.application.usecase.dto.LoanDTO;
import xyz.willferguson.library.application.usecase.dto.mapper.DTOMapper;
import xyz.willferguson.library.domain.entity.Book;
import xyz.willferguson.library.domain.entity.Library;
import xyz.willferguson.library.domain.entity.Loan;
import xyz.willferguson.library.domain.entity.Person;
import xyz.willferguson.library.domain.exceptions.BookNotAvailableException;
import xyz.willferguson.library.domain.exceptions.LoanNotAllowedException;
import xyz.willferguson.library.domain.repository.BookRepository;
import xyz.willferguson.library.domain.repository.LoanRepository;
import xyz.willferguson.library.domain.repository.PersonRepository;

import java.util.UUID;

//TODO How do we handle the race condition when the same book is borrowed by 2 different threads
public class BorrowBook {

    private Library library;
    private PersonRepository personRepository;
    private LoanRepository loanRepository;
    private BookRepository bookRepository;

    private DTOMapper<LoanDTO, Loan> mapper;

    public BorrowBook(Library library, PersonRepository personRepository, LoanRepository loanRepository, BookRepository bookRepository, DTOMapper<LoanDTO, Loan> mapper) {
        this.library = library;
        this.personRepository = personRepository;
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    public LoanDTO borrowBook(UUID borrowerId, UUID bookId) throws BookNotAvailableException, LoanNotAllowedException {
        Book book = bookRepository.get(bookId);
        Person borrower = personRepository.get(borrowerId);

        Loan loan = library.borrowBook(borrower, book);
        Loan createdLoan = loanRepository.create(loan);
        return mapper.toDTO(createdLoan);

    }
}
