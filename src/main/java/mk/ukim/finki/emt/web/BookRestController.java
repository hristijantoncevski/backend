package mk.ukim.finki.emt.web;

import mk.ukim.finki.emt.model.Book;
import mk.ukim.finki.emt.model.dto.BookDto;
import mk.ukim.finki.emt.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    private List<Book> findAll(){
        return this.bookService.listAll();
    }

    @GetMapping
    public List<Book> listBooksPaginated(Pageable pageable) {
        return this.bookService.listBooksPaginated(pageable).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.create(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.update(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        this.bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/take/{id}")
    public ResponseEntity<Book> take(@PathVariable Long id){
        return this.bookService.take(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}