package xyz.willferguson.library.application.usecase;

import xyz.willferguson.library.application.usecase.dto.BookDTO;
import xyz.willferguson.library.application.usecase.dto.mapper.DTOMapper;
import xyz.willferguson.library.domain.entity.Book;
import xyz.willferguson.library.domain.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ListBooksUseCase {

    BookRepository bookRepository;
    DTOMapper<BookDTO, Book> mapper;

    public ListBooksUseCase(BookRepository bookRepository, DTOMapper<BookDTO, Book> mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    public List<BookDTO> listBooks() {
        return bookRepository.list()
                .stream()
                .map(entity -> mapper.toDTO(entity, BookDTO.class))
                .collect(Collectors.toList());
    }


}
