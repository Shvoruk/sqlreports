package com.example.sqlreports.cityReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository <CityEntity, Integer> {

    @Query("SELECT Name, Population FROM city ORDER BY Population DESC")
    List<CityEntity> findAllCitiesByWorldOrderedByPopulation();
}
