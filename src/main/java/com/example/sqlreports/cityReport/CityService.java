package com.example.sqlreports.cityReport;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityEntity> getAllCountriesInWorld() {
        return cityRepository.findAllCitiesByWorldOrderedByPopulation();
    }

    public List<CityEntity> getAllCountriesInContinent(String continent) {
        return cityRepository.findAllCitiesByContinentOrderedByPopulation(continent);
    }

    public List<CityEntity> getAllCountriesInRegion(String region) {
        return cityRepository.findAllCitiesByRegionOrderByPopulation(region);
    }

    public List<CityEntity> getAllCountriesInCountry(String country) {
        return cityRepository.findAllCitiesByCountryOrderedByPopulation(country);
    }

    public List<CityEntity> getAllCountriesInDistrict(String district) {
        return cityRepository.findAllCitiesByDistrictOrderByPopulation(district);
    }
}
