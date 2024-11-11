package com.example.sqlreports.countryReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository <CountryEntity, String> {


    @Query("SELECT Name, Population FROM country ORDER BY Population DESC")
    List<CountryEntity> findAllCountriesByWorldOrderedByPopulation();

    @Query("SELECT Name, Population FROM country WHERE Continent = :continent ORDER BY Population DESC")
    List<CountryEntity> findCountriesByContinentOrderedByPopulation(String continent);

    @Query("SELECT Name, Population FROM country WHERE Region = :region ORDER BY Population DESC")
    List<CountryEntity> findCountriesByRegionOrderedByPopulation(String region);

    @Query("SELECT Name, Population FROM country ORDER BY Population DESC LIMIT :limit")
    List<CountryEntity> findAllCountriesWithLimitByWorldOrderedByPopulation(Integer limit);

    @Query("SELECT Name, Population FROM country WHERE Continent = :continent ORDER BY Population DESC LIMIT :limit")
    List<CountryEntity> findCountriesWithLimitByContinentOrderedByPopulation(String continent, Integer limit);

    @Query("SELECT Name, Population FROM country WHERE Region = :region ORDER BY Population DESC LIMIT :limit")
    List<CountryEntity> findCountriesWithLimitByRegionOrderedByPopulation(String region, Integer limit);
}
