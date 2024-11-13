package com.example.sqlreports.countryReport;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryEntity> getAllCountriesInWorld() {
        return countryRepository.findAllCountriesByWorldOrderedByPopulation();
    }

    public List<CountryEntity> getAllCountriesInContinent(String continent) {
        return countryRepository.findCountriesByContinentOrderedByPopulation(continent);
    }

    public List<CountryEntity> getAllCountriesInRegion(String region) {
        return countryRepository.findCountriesByRegionOrderedByPopulation(region);
    }

    public List<CountryEntity> getAllCountriesInWorldLimited(Integer limit) {
        return countryRepository.findAllCountriesWithLimitByWorldOrderedByPopulation(limit);
    }

    public List<CountryEntity> getAllCountriesInContinentLimited(String continent, Integer limit) {
        return countryRepository.findCountriesWithLimitByContinentOrderedByPopulation(continent, limit);
    }

    public List<CountryEntity> getAllCountriesInRegionLimited(String region, Integer limit) {
        return countryRepository.findCountriesWithLimitByRegionOrderedByPopulation(region, limit);
    }
}
