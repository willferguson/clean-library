package xyz.willferguson.library.data.repository;

import xyz.willferguson.library.domain.entity.Book;
import xyz.willferguson.library.domain.repository.BookRepository;

public class InMemoryBookRepository extends InMemoryRepository<Book> implements BookRepository {

}
