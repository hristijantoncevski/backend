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
        CountryDto country1 = new CountryDto("Macedonia", "Europe");
        CountryDto country2 = new CountryDto("Serbia", "Europe");
        CountryDto country3 = new CountryDto("USA", "North America");
        CountryDto country4 = new CountryDto("Japan", "Asia");
        CountryDto country5 = new CountryDto("Argentina", "South America");
        CountryDto country6 = new CountryDto("Croatia", "Europe");
        CountryDto country7 = new CountryDto("United Kingdom", "Europe");
        CountryDto country8 = new CountryDto("Italy", "Europe");
        CountryDto country9 = new CountryDto("Switzerland", "Europe");

        countryService.create(country1);
        countryService.create(country2);
        countryService.create(country3);
        countryService.create(country4);
        countryService.create(country5);
        countryService.create(country6);
        countryService.create(country7);
        countryService.create(country8);
        countryService.create(country9);

        AuthorDto author1 = new AuthorDto("Hristijan","Toncevski", 1L);
        AuthorDto author2 = new AuthorDto("Novak","Djokovic", 2L);
        AuthorDto author3 = new AuthorDto("Roman","Atwood", 3L);
        AuthorDto author4 = new AuthorDto("JapanName","JapanSurname", 4L);
        AuthorDto author5 = new AuthorDto("Lionel","Messi", 5L);
        AuthorDto author6 = new AuthorDto("Pavel","Stefanovski", 6L);
        AuthorDto author7 = new AuthorDto("Harry","Kane", 7L);
        AuthorDto author8 = new AuthorDto("Gordon","Ramsey", 8L);
        AuthorDto author9 = new AuthorDto("Tony","Balloni", 9L);
        AuthorDto author10 = new AuthorDto("Hristijan","Toncevski2", 1L);
        AuthorDto author11 = new AuthorDto("Hristijan","Toncevski3", 1L);
        AuthorDto author12 = new AuthorDto("Hristijan","Toncevski4", 1L);
        AuthorDto author13 = new AuthorDto("Hristijan","Toncevski5", 1L);
        AuthorDto author14 = new AuthorDto("Hristijan","Toncevski6", 1L);

        authorService.create(author1);
        authorService.create(author2);
        authorService.create(author3);
        authorService.create(author4);
        authorService.create(author5);
        authorService.create(author6);
        authorService.create(author7);
        authorService.create(author8);
        authorService.create(author9);
        authorService.create(author10);
        authorService.create(author11);
        authorService.create(author12);
        authorService.create(author13);
        authorService.create(author14);

        this.bookService.create(new BookDto("Kniga1",NOVEL,1L,14));
        this.bookService.create(new BookDto("Kniga2",HISTORY,2L,26));
        this.bookService.create(new BookDto("Kniga3",FANTASY,3L,42));
        this.bookService.create(new BookDto("Kniga4",BIOGRAPHY,4L,46));
        this.bookService.create(new BookDto("Kniga5",CLASSICS,5L,78));
        this.bookService.create(new BookDto("Kniga6",DRAMA,6L,33));
        this.bookService.create(new BookDto("Kniga7",BIOGRAPHY,7L,18));
        this.bookService.create(new BookDto("Kniga8",THRILLER,8L,10));
        this.bookService.create(new BookDto("Kniga9",DRAMA,9L,64));
        this.bookService.create(new BookDto("Kniga10",FANTASY,1L,17));
        this.bookService.create(new BookDto("Kniga11",NOVEL,3L,29));
        this.bookService.create(new BookDto("Kniga12",HISTORY,9L,48));
        this.bookService.create(new BookDto("Kniga13",BIOGRAPHY,1L,33));
        this.bookService.create(new BookDto("Kniga14",THRILLER,8L,21));
        this.bookService.create(new BookDto("Kniga15",HISTORY,3L,113));
        this.bookService.create(new BookDto("Kniga16",THRILLER,2L,127));
        this.bookService.create(new BookDto("Kniga17",FANTASY,1L,13));
        this.bookService.create(new BookDto("Kniga18",DRAMA,6L,19));
        this.bookService.create(new BookDto("Kniga19",CLASSICS,3L,7));
        this.bookService.create(new BookDto("Kniga20",THRILLER,5L,10));
        this.bookService.create(new BookDto("Kniga21",FANTASY,4L,24));
    }
}
