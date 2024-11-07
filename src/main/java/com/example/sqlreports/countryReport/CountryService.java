package com.example.sqlreports.countryReport;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryEntity> getAllCountriesLargestToSmallest() {
        return countryRepository.findAllCountriesLargestToSmallest();
    }
}
