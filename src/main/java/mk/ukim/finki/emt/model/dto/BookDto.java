package mk.ukim.finki.emt.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import mk.ukim.finki.emt.model.enumeration.BookCategory;

@Data
public class BookDto {
    private String name;
    private BookCategory category;
    private Long author;
    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, BookCategory category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }
}
