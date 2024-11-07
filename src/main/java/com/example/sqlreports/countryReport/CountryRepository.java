package com.example.sqlreports.countryReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository {

    @Query( "SELECT Name, Population FROM country ORDER BY Population DESC" )
    List<CountryEntity> findAllCountriesLargestToSmallest();
}
