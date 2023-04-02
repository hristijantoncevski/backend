package mk.ukim.finki.emt.service.impl;

import mk.ukim.finki.emt.model.Author;
import mk.ukim.finki.emt.model.Country;
import mk.ukim.finki.emt.model.dto.AuthorDto;
import mk.ukim.finki.emt.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.repository.AuthorRepository;
import mk.ukim.finki.emt.repository.CountryRepository;
import mk.ukim.finki.emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> create(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getCountryId()).orElseThrow(CountryNotFoundException::new);
        return Optional.of(this.authorRepository.save(new Author(authorDto.getName(),authorDto.getSurname(),country)));
    }


    @Override
    public Optional<Author> edit(Long id, AuthorDto authorDto) {
        Author author=this.authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        Country country=this.countryRepository.findById(authorDto.getCountryId()).orElseThrow(CountryNotFoundException::new);
        author.setCountry(country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
