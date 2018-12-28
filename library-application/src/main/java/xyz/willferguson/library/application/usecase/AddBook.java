package xyz.willferguson.library.application.usecase;

import xyz.willferguson.library.application.usecase.dto.BookDTO;
import xyz.willferguson.library.application.usecase.dto.mapper.DTOMapper;
import xyz.willferguson.library.domain.entity.Book;
import xyz.willferguson.library.domain.entity.Person;
import xyz.willferguson.library.domain.exceptions.InvaidOperationException;
import xyz.willferguson.library.domain.repository.BookRepository;
import xyz.willferguson.library.domain.repository.PersonRepository;

import java.util.UUID;

/**
 * Only Librarians can add books
 */
public class AddBook {

    private final BookRepository bookRepository;
    private final PersonRepository personRepository;
    private final DTOMapper<BookDTO, Book> mapper;

    public AddBook(BookRepository bookRepository, PersonRepository personRepository, DTOMapper<BookDTO, Book> mapper) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    public BookDTO addBook(BookDTO bookDTO, UUID currentPersonId) {
        Person person = personRepository.get(currentPersonId);
        if (!person.isLibrarian()) {
            throw new InvaidOperationException("Not a librarian");
        }
        Book book = mapper.fromDTO(bookDTO);
        return mapper.toDTO(bookRepository.create(book));
    }
}
