package com.example.sqlreports.cityReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository <CityEntity, Integer> {

    @Query("SELECT city.Name AS Name, country.Name AS Country, District, city.Population AS Population FROM city JOIN country ON  city.CountryCode = country.Code ORDER BY Population DESC")
    List<CityEntity> findAllCitiesByWorldOrderedByPopulation();

    @Query("SELECT city.Name AS Name, country.Name AS Country, District, city.Population AS Population FROM city JOIN country ON  city.CountryCode = country.Code WHERE country.Continent = :continent ORDER BY city.Population DESC")
    List<CityEntity> findAllCitiesByContinentOrderedByPopulation(String continent);

    @Query("SELECT city.Name AS Name, country.Name AS Country, District, city.Population AS Population FROM city JOIN country ON  city.CountryCode = country.Code  WHERE country.Name = :country  ORDER BY Population DESC")
    List<CityEntity> findAllCitiesByCountryOrderedByPopulation(String country);

    @Query("SELECT city.Name AS Name, country.Name AS Country, District, city.Population AS Population FROM city JOIN country ON  city.CountryCode = country.Code WHERE country.Region = :region ORDER BY city.Population DESC")
    List<CityEntity> findAllCitiesByRegionOrderedByPopulation(String region);

    @Query("SELECT city.Name AS Name, country.Name AS Country, District, city.Population AS Population FROM city JOIN country ON  city.CountryCode = country.Code WHERE District = :district ORDER BY Population DESC")
    List<CityEntity> findAllCitiesByDistrictOrderedByPopulation(String district);

    @Query("SELECT city.Name AS Name, country.Name AS Country, District, city.Population AS Population FROM city JOIN country ON  city.CountryCode = country.Code ORDER BY Population DESC LIMIT :limit")
    List<CityEntity> findCitiesWithLimitByWorldOrderedByPopulation(Integer limit);

    @Query("SELECT city.Name AS Name, country.Name AS Country, District, city.Population AS Population FROM city JOIN country ON  city.CountryCode = country.Code WHERE country.Continent = :continent ORDER BY city.Population DESC LIMIT :limit")
    List<CityEntity> findCitiesWithLimitByContinentOrderedByPopulation(String continent, Integer limit);

    @Query("SELECT city.Name AS Name, country.Name AS Country, District, city.Population AS Population FROM city JOIN country ON  city.CountryCode = country.Code WHERE country.Region = :region ORDER BY city.Population DESC LIMIT :limit")
    List<CityEntity> findCitiesWithLimitByRegionOrderedByPopulation(String region, Integer limit);

    @Query("SELECT city.Name AS Name, country.Name AS Country, District, city.Population AS Population FROM city JOIN country ON  city.CountryCode = country.Code WHERE country.Name = :country ORDER BY Population DESC LIMIT :limit")
    List<CityEntity> findCitiesWithLimitByCountryOrderedByPopulation(String country, Integer limit);

    @Query("SELECT city.Name AS Name, country.Name AS Country, District, city.Population AS Population FROM city JOIN country ON  city.CountryCode = country.Code WHERE District = :district ORDER BY Population DESC LIMIT :limit")
    List<CityEntity> findCitiesWithLimitByDistrictOrderedByPopulation(String district, Integer limit);
}
