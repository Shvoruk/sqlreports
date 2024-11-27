package com.example.sqlreports.populationReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo extends CrudRepository<Country, Integer> {

    @Query("SELECT \n" +
            "    country.Name,\n" +
            "    country.Population AS Total_Population,\n" +
            "    SUM(city.Population) AS City_Population,\n" +
            "    CONCAT(ROUND(SUM(city.Population) / country.Population * 100, 2), '%') AS City_Percentage,\n" +
            "    (country.Population - SUM(city.Population)) AS Rural_Population,\n" +
            "    CONCAT(ROUND((country.Population - SUM(city.Population)) / country.Population * 100, 2), '%') AS Rural_Percentage\n" +
            "FROM country \n" +
            "LEFT JOIN city ON country.Code = city.CountryCode  \n" +
            "GROUP BY country.Code")
    List<Country> findPopulationInCountryFiltered();

}
