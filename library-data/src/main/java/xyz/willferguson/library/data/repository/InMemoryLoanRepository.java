package xyz.willferguson.library.data.repository;

import xyz.willferguson.library.domain.entity.Loan;
import xyz.willferguson.library.domain.repository.LoanRepository;

import java.util.Optional;
import java.util.UUID;

public class InMemoryLoanRepository extends InMemoryRepository<Loan> implements LoanRepository {

    @Override
    public Optional<Loan> getByBookId(UUID bookId) {
        return repo.values().stream().filter(loan -> loan.getBookId().equals(bookId)).findFirst();
    }
}
