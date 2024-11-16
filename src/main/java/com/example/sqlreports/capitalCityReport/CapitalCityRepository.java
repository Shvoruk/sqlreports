package com.example.sqlreports.capitalCityReport;

import com.example.sqlreports.cityReport.CityEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CapitalCityRepository extends CrudRepository<CityEntity, Integer> {

    @Query("SELECT city.Name, city.CountryCode, city.Population FROM city JOIN country ON city.ID = country.Capital ORDER BY city.Population DESC")
    List<CityEntity> findAllCapitalCitiesByWorldOrderedByPopulation();

    @Query("SELECT city.Name, city.CountryCode, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Continent = :continent ORDER BY city.Population DESC")
    List<CityEntity> findAllCapitalCitiesByContinentOrderedByPopulation(String continent);

    @Query("SELECT city.Name, city.CountryCode, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Region = :region ORDER BY city.Population DESC")
    List<CityEntity> findAllCapitalCitiesByRegionOrderedByPopulation(String region);

    @Query("SELECT city.Name, city.CountryCode, city.Population FROM city JOIN country ON city.ID = country.Capital ORDER BY city.Population DESC LIMIT :limit")
    List<CityEntity> findAllCapitalCitiesWithLimitByWorldOrderedByPopulation(Integer limit);

    @Query("SELECT city.Name, city.CountryCode, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Continent = :continent ORDER BY city.Population DESC LIMIT :limit")
    List<CityEntity> findAllCapitalCitiesWithLimitByContinentOrderedByPopulation(String continent, Integer limit);

    @Query("SELECT city.Name, city.CountryCode, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Region = :region ORDER BY city.Population DESC LIMIT :limit")
    List<CityEntity> findAllCapitalCitiesWithLimitByRegionOrderedByPopulation(String region,Integer limit);
}

