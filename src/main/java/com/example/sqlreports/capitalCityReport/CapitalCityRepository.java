package com.example.sqlreports.capitalCityReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CapitalCityRepository extends CrudRepository<CapitalCityEntity, Integer> {

    @Query("SELECT city.Name AS Name, country.Name AS Country, city.Population FROM city JOIN country ON city.ID = country.Capital ORDER BY city.Population DESC")
    List<CapitalCityEntity> findAllCapitalCitiesByWorldOrderedByPopulation();

    @Query("SELECT city.Name AS Name, country.Name AS Country, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Continent = :continent ORDER BY city.Population DESC")
    List<CapitalCityEntity> findAllCapitalCitiesByContinentOrderedByPopulation(String continent);

    @Query("SELECT city.Name AS Name, country.Name AS Country, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Region = :region ORDER BY city.Population DESC")
    List<CapitalCityEntity> findAllCapitalCitiesByRegionOrderedByPopulation(String region);

    @Query("SELECT city.Name AS Name, country.Name AS Country, city.Population FROM city JOIN country ON city.ID = country.Capital ORDER BY city.Population DESC LIMIT :limit")
    List<CapitalCityEntity> findAllCapitalCitiesWithLimitByWorldOrderedByPopulation(Integer limit);

    @Query("SELECT city.Name AS Name, country.Name AS Country, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Continent = :continent ORDER BY city.Population DESC LIMIT :limit")
    List<CapitalCityEntity> findAllCapitalCitiesWithLimitByContinentOrderedByPopulation(String continent, Integer limit);

    @Query("SELECT city.Name AS Name, country.Name AS Country, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Region = :region ORDER BY city.Population DESC LIMIT :limit")
    List<CapitalCityEntity> findAllCapitalCitiesWithLimitByRegionOrderedByPopulation(String region,Integer limit);
}

