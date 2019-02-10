package xyz.willferguson.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import xyz.willferguson.library.application.usecase.AddBookUseCase;
import xyz.willferguson.library.application.usecase.dto.BookDTO;
import xyz.willferguson.library.domain.exceptions.EntityExistsException;
import xyz.willferguson.library.domain.exceptions.NoSuchPersonException;

import java.util.UUID;

@RestController("book")
public class BookController {

    private AddBookUseCase addBookUseCase;

    @Autowired
    public BookController(AddBookUseCase addBookUseCase) {
        this.addBookUseCase = addBookUseCase;
    }


    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO, @RequestHeader("userId") String userId) {
        try {
            return ResponseEntity.ok(addBookUseCase.addBook(bookDTO, UUID.fromString(userId)));
        } catch (NoSuchPersonException e) {
            return ResponseEntity.status(403).build();
        } catch (EntityExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
