package com.example.sqlreports.populationReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo extends CrudRepository<Country, Integer> {

    @Query("SELECT country.Name, country.Population AS total_population, SUM(city.Population) AS city_population, country.Population - SUM(city.Population) AS rural_population FROM country LEFT JOIN city ON country.Code = city.CountryCode GROUP BY country.Code")
    List<Country> findPopulationInCountryFiltered();

}
