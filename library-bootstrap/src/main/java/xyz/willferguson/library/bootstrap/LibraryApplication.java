package xyz.willferguson.library.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xyz.willferguson.library.application.usecase.AddBookUseCase;
import xyz.willferguson.library.application.usecase.dto.BookDTO;
import xyz.willferguson.library.application.usecase.dto.mapper.DTOMapper;
import xyz.willferguson.library.application.usecase.dto.mapper.SimpleBeanMapper;
import xyz.willferguson.library.data.repository.InMemoryBookRepository;
import xyz.willferguson.library.data.repository.InMemoryPersonRepository;
import xyz.willferguson.library.domain.entity.Book;
import xyz.willferguson.library.domain.repository.BookRepository;
import xyz.willferguson.library.domain.repository.PersonRepository;
import xyz.willferguson.library.web.BookController;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    BookController bookController(AddBookUseCase addBookUseCase) {
        return new BookController(addBookUseCase);
    }

    @Bean
    AddBookUseCase addBookUseCase(
            BookRepository bookRepository,
            PersonRepository personRepository,
            DTOMapper<BookDTO, Book> mapper) {
        return new AddBookUseCase(bookRepository, personRepository, mapper);
    }

    @Bean
    DTOMapper<BookDTO, Book> mapper() {
        return new SimpleBeanMapper<>();
    }

    @Bean
    PersonRepository personRepository() {
        return new InMemoryPersonRepository();
    }

    @Bean
    BookRepository bookRepository() {
        return new InMemoryBookRepository();
    }
}
