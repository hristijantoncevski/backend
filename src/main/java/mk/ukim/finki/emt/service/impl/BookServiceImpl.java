package mk.ukim.finki.emt.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt.model.Author;
import mk.ukim.finki.emt.model.Book;
import mk.ukim.finki.emt.model.dto.BookDto;
import mk.ukim.finki.emt.model.enumeration.BookCategory;
import mk.ukim.finki.emt.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.repository.AuthorRepository;
import mk.ukim.finki.emt.repository.BookRepository;
import mk.ukim.finki.emt.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Page<Book> listBooksPaginated(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);
        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book=this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        Author author=this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(AuthorNotFoundException::new);
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> take(Long id){
        int n;
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        if(book.getAvailableCopies() > 0){
            n = book.getAvailableCopies() - 1;
        } else {
            n = book.getAvailableCopies();
        }
        book.setAvailableCopies(n);
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
