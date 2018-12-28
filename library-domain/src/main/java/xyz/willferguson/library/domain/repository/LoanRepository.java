package xyz.willferguson.library.domain.repository;

import xyz.willferguson.library.domain.entity.Loan;

import java.util.UUID;

public interface LoanRepository extends GenericRepository<Loan> {
    Loan getByBookId(UUID bookId);
}
