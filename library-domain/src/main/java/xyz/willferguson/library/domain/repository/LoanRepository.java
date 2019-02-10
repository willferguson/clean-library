package xyz.willferguson.library.domain.repository;

import xyz.willferguson.library.domain.entity.Loan;

import java.util.Optional;
import java.util.UUID;

public interface LoanRepository extends GenericRepository<Loan> {
    Optional<Loan> getByBookId(UUID bookId);
}
