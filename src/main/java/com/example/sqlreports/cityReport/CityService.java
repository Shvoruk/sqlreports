package com.example.sqlreports.cityReport;

import com.example.sqlreports.countryReport.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityEntity> getAllCitiesInWorld() {
        return cityRepository.findAllCitiesByWorldOrderedByPopulation();
    }

    public List<CityEntity> getAllCitiesInContinent(String continent) {
        return cityRepository.findAllCitiesByContinentOrderedByPopulation(continent);
    }

    public List<CityEntity> getAllCitiesInRegion(String region) {
        return cityRepository.findAllCitiesByRegionOrderedByPopulation(region);
    }

    public List<CityEntity> getAllCitiesInCountry(String country) {
        return cityRepository.findAllCitiesByCountryOrderedByPopulation(country);
    }

    public List<CityEntity> getAllCitiesInDistrict(String district) {
        return cityRepository.findAllCitiesByDistrictOrderedByPopulation(district);
    }

    public List<CityEntity> getAllCitiesInWorldLimited(Integer limit) {
        return cityRepository.findCitiesWithLimitByWorldOrderedByPopulation(limit);
    }

    public List<CityEntity> getAllCitiesInContinentLimited(String continent, Integer limit) {
        return cityRepository.findCitiesWithLimitByContinentOrderedByPopulation(continent, limit);
    }

    public List<CityEntity> getAllCitiesInRegionLimited(String region, Integer limit) {
        return cityRepository.findCitiesWithLimitByRegionOrderedByPopulation(region, limit);
    }

    public List<CityEntity> getAllCitiesInCountryLimited(String country, Integer limit) {
        return cityRepository.findCitiesWithLimitByCountryOrderedByPopulation(country, limit);
    }

    public List<CityEntity> getAllCitiesInDistrictLimited(String district, Integer limit) {
        return cityRepository.findCitiesWithLimitByDistrictOrderedByPopulation(district, limit);
    }


}
