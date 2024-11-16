package com.example.sqlreports.populationReport;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationService {

    private final CountryRepo countryRepository;
    private final RegionRepository regionRepository;
    private final ContinentRepository continentRepository;
    private final PopulationRepository populationRepository;

    public PopulationService(CountryRepo countryRepository, RegionRepository regionRepository, ContinentRepository continentRepository, PopulationRepository populationRepository) {
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
        this.continentRepository = continentRepository;
        this.populationRepository = populationRepository;
    }

    public List<Country> getCountriesFiltered() {
        return countryRepository.findPopulationInCountryFiltered();
    }

    public List<Region> getRegionsFiltered() {
        return regionRepository.findPopulationInRegionFiltered();
    }

    public List<Continent> getContinentsFiltered() {
        return continentRepository.findPopulationInContinentFiltered();
    }

    public List<PopulationEntity> getPopulationInWorld(){
        return populationRepository.findPopulationInWorld();
    }

    public List<PopulationEntity> getPopulationInContinent(String continent){
        return populationRepository.findPopulationInContinent(continent);
    }

    public List<PopulationEntity> getPopulationInRegion(String region){
        return populationRepository.findPopulationInRegion(region);
    }

    public List<PopulationEntity> getPopulationInCountry(String country){
        return populationRepository.findPopulationInCountry(country);
    }

    public List<PopulationEntity> getPopulationInDistrict(String district){
        return populationRepository.findPopulationInDistrict(district);
    }

    public List<PopulationEntity> getPopulationInCity(String city){
        return populationRepository.findPopulationInCity(city);
    }
}
