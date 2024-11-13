package com.example.sqlreports.capitalCityReport;

import com.example.sqlreports.cityReport.CityEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitalCityService {

    private final CapitalCityRepository capitalCityRepository;

    public CapitalCityService(CapitalCityRepository capitalCityRepository) {
        this.capitalCityRepository = capitalCityRepository;
    }

    public List<CityEntity> getAllCapitalCitiesInWorld() {
        return capitalCityRepository.findAllCapitalCitiesByWorldOrderedByPopulation();
    }

    public List<CityEntity> getAllCapitalCitiesInContinent(String continent) {
        return capitalCityRepository.findAllCapitalCitiesByContinentOrderedByPopulation(continent);
    }

    public List<CityEntity> getAllCapitalCitiesInRegion(String region) {
        return capitalCityRepository.findAllCapitalCitiesByRegionOrderedByPopulation(region);
    }

    public List<CityEntity> getAllCapitalCitiesInWorldLimited(Integer limit) {
        return capitalCityRepository.findAllCapitalCitiesWithLimitByWorldOrderedByPopulation(limit);
    }

    public List<CityEntity> getAllCapitalCitiesInContinentLimited(String continent, Integer limit) {
        return capitalCityRepository.findAllCapitalCitiesWithLimitByContinentOrderedByPopulation(continent, limit);
    }

    public List<CityEntity> getAllCapitalCitiesInRegionLimited(String region, Integer limit) {
        return capitalCityRepository.findAllCapitalCitiesWithLimitByRegionOrderedByPopulation(region, limit);
    }


}
