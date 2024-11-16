package com.example.sqlreports.capitalCityReport;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitalCityService {

    private final CapitalCityRepository capitalCityRepository;

    public CapitalCityService(CapitalCityRepository capitalCityRepository) {
        this.capitalCityRepository = capitalCityRepository;
    }

    public List<CapitalCityEntity> getAllCapitalCitiesInWorld() {
        return capitalCityRepository.findAllCapitalCitiesByWorldOrderedByPopulation();
    }

    public List<CapitalCityEntity> getAllCapitalCitiesInContinent(String continent) {
        return capitalCityRepository.findAllCapitalCitiesByContinentOrderedByPopulation(continent);
    }

    public List<CapitalCityEntity> getAllCapitalCitiesInRegion(String region) {
        return capitalCityRepository.findAllCapitalCitiesByRegionOrderedByPopulation(region);
    }

    public List<CapitalCityEntity> getAllCapitalCitiesInWorldLimited(Integer limit) {
        return capitalCityRepository.findAllCapitalCitiesWithLimitByWorldOrderedByPopulation(limit);
    }

    public List<CapitalCityEntity> getAllCapitalCitiesInContinentLimited(String continent, Integer limit) {
        return capitalCityRepository.findAllCapitalCitiesWithLimitByContinentOrderedByPopulation(continent, limit);
    }

    public List<CapitalCityEntity> getAllCapitalCitiesInRegionLimited(String region, Integer limit) {
        return capitalCityRepository.findAllCapitalCitiesWithLimitByRegionOrderedByPopulation(region, limit);
    }


}
