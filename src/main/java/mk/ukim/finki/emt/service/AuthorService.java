package mk.ukim.finki.emt.service;

import mk.ukim.finki.emt.model.Author;
import mk.ukim.finki.emt.model.Country;
import mk.ukim.finki.emt.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAll();
    Optional<Author> create(AuthorDto authorDto);
    Optional<Author> findById(Long id);
    Optional<Author> edit(Long id, AuthorDto authorDto);
    void deleteById(Long id);
}
