package com.example.sqlreports.populationReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends CrudRepository<Region, Integer> {

    @Query("SELECT \n" +
            "    country.Region AS Region,\n" +
            "    SUM(country.Population) AS Total_Population,  \n" +
            "    SUM(city.Population) AS City_Population,\n" +
            "    CONCAT(ROUND(SUM(city.Population) / SUM(country.Population) * 100, 2), '%') AS City_Percentage,  \n" +
            "    (SUM(country.Population) - SUM(city.Population)) AS Rural_Population,\n" +
            "    CONCAT(ROUND((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population) * 100, 2), '%') AS Rural_Percentage  \n" +
            "FROM country\n" +
            "LEFT JOIN city ON country.Code = city.CountryCode  \n" +
            "GROUP BY country.Region")
    List<Region> findPopulationInRegionFiltered();
}
