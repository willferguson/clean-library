package xyz.willferguson.library.application.usecase;

import xyz.willferguson.library.domain.entity.Book;
import xyz.willferguson.library.domain.entity.Library;
import xyz.willferguson.library.domain.entity.Loan;
import xyz.willferguson.library.domain.entity.Person;
import xyz.willferguson.library.domain.exceptions.EntityDoesNotExistException;
import xyz.willferguson.library.domain.repository.BookRepository;
import xyz.willferguson.library.domain.repository.LoanRepository;
import xyz.willferguson.library.domain.repository.PersonRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class ReturnBookUseCase {

    private LoanRepository loanRepository;
    private Library library;
    private PersonRepository personRepository;
    private BookRepository bookRepository;

    public ReturnBookUseCase(LoanRepository loanRepository, Library library, PersonRepository personRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.library = library;
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
    }

    public void returnBook(UUID personId, UUID bookId) throws EntityDoesNotExistException {

        Loan loan = loanRepository.getByBookId(bookId).orElseThrow(() -> new EntityDoesNotExistException("No book with id" + bookId));
        if (loan.isLate()) {
            BigDecimal fine = library.calculateFine(loan.getReturnDate());
            Person person = personRepository.get(personId).orElseThrow(() -> new EntityDoesNotExistException("No person with this id"));
            person.addFine(fine);
        }
        Book book = bookRepository.get(loan.getBookId()).orElseThrow(() -> new EntityDoesNotExistException("No loan with book id"));
        book.returnBook();
        bookRepository.update(book);
        loanRepository.delete(loan.getId());
    }
}
