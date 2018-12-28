package xyz.willferguson.library.application.usecase;

import xyz.willferguson.library.domain.entity.Library;
import xyz.willferguson.library.domain.entity.Loan;
import xyz.willferguson.library.domain.entity.Person;
import xyz.willferguson.library.domain.repository.LoanRepository;
import xyz.willferguson.library.domain.repository.PersonRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class ReturnBook {

    private LoanRepository loanRepository;
    private Library library;
    private PersonRepository personRepository;

    public ReturnBook(LoanRepository loanRepository, Library library, PersonRepository personRepository) {
        this.loanRepository = loanRepository;
        this.library = library;
        this.personRepository = personRepository;
    }

    public void returnBook(UUID personId, UUID bookId) {

        Loan loan = loanRepository.getByBookId(bookId);
        if (loan.isLate()) {
            BigDecimal fine = library.calculateFine(loan.getReturnDate());
            Person person = personRepository.get(personId);
            person.addFine(fine);
        }
        loanRepository.delete(loan.getUuid());

    }
}
