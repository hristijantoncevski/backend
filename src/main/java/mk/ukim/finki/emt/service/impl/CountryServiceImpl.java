package mk.ukim.finki.emt.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt.model.Country;
import mk.ukim.finki.emt.model.dto.CountryDto;
import mk.ukim.finki.emt.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.repository.CountryRepository;
import mk.ukim.finki.emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> create(CountryDto countryDto) {
        Country country=new Country(countryDto.getName(), countryDto.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> update(Long id, CountryDto countryDto) {
        Country country=this.countryRepository.findById(id).orElseThrow(CountryNotFoundException::new);
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
