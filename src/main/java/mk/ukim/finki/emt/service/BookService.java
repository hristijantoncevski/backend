package mk.ukim.finki.emt.service;

import mk.ukim.finki.emt.model.Book;
import mk.ukim.finki.emt.model.dto.BookDto;
import mk.ukim.finki.emt.model.enumeration.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    Page<Book> listBooksPaginated(Pageable pageable);
    Optional<Book> findById(Long id);
    Optional<Book> create(BookDto productDto);
    Optional<Book> update(Long id, BookDto bookDto);
    void deleteById(Long id);
    Optional<Book> take(Long id);
}
