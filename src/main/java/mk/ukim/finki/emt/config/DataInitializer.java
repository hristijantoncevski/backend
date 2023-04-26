package mk.ukim.finki.emt.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt.model.dto.AuthorDto;
import mk.ukim.finki.emt.model.dto.BookDto;
import mk.ukim.finki.emt.model.dto.CountryDto;
import mk.ukim.finki.emt.service.AuthorService;
import mk.ukim.finki.emt.service.BookService;
import mk.ukim.finki.emt.service.CountryService;
import org.springframework.stereotype.Component;

import static mk.ukim.finki.emt.model.enumeration.BookCategory.*;

@Component
public class DataInitializer {
    private final AuthorService authorService;
    private final CountryService countryService;
    private final BookService bookService;

    public DataInitializer(AuthorService authorService, CountryService countryService, BookService bookService) {
        this.authorService = authorService;
        this.countryService = countryService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void init() {
        this.countryService.create(new CountryDto("Macedonia", "Europe"));
        this.countryService.create(new CountryDto("Russia", "Europe/Asia"));
        this.countryService.create(new CountryDto("USA", "North America"));
        this.countryService.create(new CountryDto("Japan", "Asia"));
        this.countryService.create(new CountryDto("France", "Europe"));
        this.countryService.create(new CountryDto("Germany", "Europe"));
        this.countryService.create(new CountryDto("United Kingdom", "Europe"));
        this.countryService.create(new CountryDto("Italy", "Europe"));
        this.countryService.create(new CountryDto("Australia", "Australia"));

        this.authorService.create(new AuthorDto("Hristijan","Toncevski", 1L));
        this.authorService.create(new AuthorDto("Leo","Tolstoy", 2L));
        this.authorService.create(new AuthorDto("Harper","Lee", 3L));
        this.authorService.create(new AuthorDto("Scott","Fitzgerald", 4L));
        this.authorService.create(new AuthorDto("Honore","de Balzac", 5L));
        this.authorService.create(new AuthorDto("Annelies","Frank", 6L));
        this.authorService.create(new AuthorDto("Agatha","Christie", 7L));
        this.authorService.create(new AuthorDto("Dante","Alighieri", 8L));
        this.authorService.create(new AuthorDto("Tim","Winton", 9L));

        this.bookService.create(new BookDto("Book",NOVEL,1L,14));
        this.bookService.create(new BookDto("Anna Karenina",HISTORY,2L,26));
        this.bookService.create(new BookDto("To Kill a Mockingbird",FANTASY,3L,42));
        this.bookService.create(new BookDto("The Great Gatsby",BIOGRAPHY,4L,46));
        this.bookService.create(new BookDto("The Magic Skin",CLASSICS,5L,78));
        this.bookService.create(new BookDto("The diary of Anne Frank",DRAMA,6L,33));
        this.bookService.create(new BookDto("Death on the Nile",BIOGRAPHY,7L,18));
        this.bookService.create(new BookDto("Divine Comedy",THRILLER,8L,10));
        this.bookService.create(new BookDto("The open swimmer",NOVEL,9L,64));
        this.bookService.create(new BookDto("Book but part 2",FANTASY,1L,17));
        this.bookService.create(new BookDto("Father Goriot",DRAMA,5L,29));
    }
}
