package com.example.sqlreports.cityReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository <CityEntity, Integer> {

    @Query("SELECT Name, Population FROM city ORDER BY Population DESC")
    List<CityEntity> findAllCitiesByWorldOrderedByPopulation();

    @Query("SELECT city.Name, city.Population FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Continent = :continent ORDER BY city.Population DESC")
    List<CityEntity> findAllCitiesByContinentOrderedByPopulation(String continent);

    @Query("SELECT Name, Population FROM city WHERE CountryCode = (SELECT Code FROM country WHERE country.Name = :country)  ORDER BY Population DESC")
    List<CityEntity> findAllCitiesByCountryOrderedByPopulation(String country);

    @Query("SELECT city.Name, city.Population FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Region = :region ORDER BY city.Population DESC")
    List<CityEntity> findAllCitiesByRegionOrderByPopulation(String region);

    @Query("SELECT Name, Population FROM city WHERE District = :district ORDER BY Population DESC")
    List<CityEntity> indAllCitiesByDistrictOrderByPopulation(String district);
}
