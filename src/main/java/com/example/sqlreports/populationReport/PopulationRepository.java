package com.example.sqlreports.populationReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopulationRepository extends CrudRepository<PopulationEntity, String> {

    @Query("SELECT SUM(Population) AS total_population FROM country")
    List<PopulationEntity> findPopulationInWorld();

    @Query("SELECT Continent AS name, SUM(Population) AS total_population FROM country WHERE Continent = :continent")
    List<PopulationEntity> findPopulationInContinent(String continent);

    @Query("SELECT Name, Population AS total_population FROM country WHERE Name = :country")
    List<PopulationEntity> findPopulationInCountry(String country);

    @Query("SELECT Region AS name, SUM(Population) AS total_population FROM country WHERE Region = :region")
    List<PopulationEntity> findPopulationInRegion(String region);

    @Query("SELECT Name, Population AS total_population FROM city WHERE Name = :city")
    List<PopulationEntity> findPopulationInCity(String city);

    @Query("SELECT District AS name, SUM(Population) AS total_population FROM city WHERE District = :district")
    List<PopulationEntity> findPopulationInDistrict(String district);

}
