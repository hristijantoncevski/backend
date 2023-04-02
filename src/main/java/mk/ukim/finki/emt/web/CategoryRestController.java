package mk.ukim.finki.emt.web;

import mk.ukim.finki.emt.model.enumeration.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryRestController {
    @GetMapping
    public List<BookCategory> listCategories() {
        return Arrays.asList(BookCategory.values());
    }
}