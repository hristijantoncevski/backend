package mk.ukim.finki.emt.service;

import mk.ukim.finki.emt.model.Country;
import mk.ukim.finki.emt.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> listAll();
    Optional<Country>findById(Long id);
    Optional<Country> create(CountryDto countryDto);
    Optional<Country> update(Long id, CountryDto countryDto);
    void deleteById(Long id);
}
