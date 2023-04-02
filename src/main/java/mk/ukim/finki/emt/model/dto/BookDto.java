package mk.ukim.finki.emt.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import mk.ukim.finki.emt.model.enumeration.BookCategory;

@Data
public class BookDto {
    private String name;
    private BookCategory bookCategory;
    private Integer availableCopies;
    private Long authorId;

    public BookDto() {
    }

    public BookDto(String name, BookCategory bookCategory, Integer availableCopies, Long authorId) {
        this.name = name;
        this.bookCategory = bookCategory;
        this.availableCopies = availableCopies;
        this.authorId = authorId;
    }
}
