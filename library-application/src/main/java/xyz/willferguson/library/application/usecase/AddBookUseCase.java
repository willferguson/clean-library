package xyz.willferguson.library.application.usecase;

import xyz.willferguson.library.application.usecase.dto.BookDTO;
import xyz.willferguson.library.application.usecase.dto.mapper.DTOMapper;
import xyz.willferguson.library.domain.entity.Book;
import xyz.willferguson.library.domain.entity.Person;
import xyz.willferguson.library.domain.exceptions.EntityDoesNotExistException;
import xyz.willferguson.library.domain.exceptions.EntityExistsException;
import xyz.willferguson.library.domain.exceptions.InvalidOperationException;
import xyz.willferguson.library.domain.exceptions.NoSuchPersonException;
import xyz.willferguson.library.domain.repository.BookRepository;
import xyz.willferguson.library.domain.repository.PersonRepository;

import java.util.UUID;

/**
 * Only Librarians can add books
 */
public class AddBookUseCase {

    private final BookRepository bookRepository;
    private final PersonRepository personRepository;
    private final DTOMapper<BookDTO, Book> mapper;

    public AddBookUseCase(BookRepository bookRepository, PersonRepository personRepository, DTOMapper<BookDTO, Book> mapper) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    public BookDTO addBook(BookDTO bookDTO, UUID currentPersonId) throws NoSuchPersonException, EntityExistsException {
        Person person = personRepository.get(currentPersonId).orElseThrow(() -> new NoSuchPersonException("No person with id" + currentPersonId));
        if (!person.isLibrarian()) {
            throw new InvalidOperationException("Not a librarian");
        }
        Book book = mapper.fromDTO(bookDTO, Book.class);
        return mapper.toDTO(bookRepository.create(book), BookDTO.class);
    }
}
