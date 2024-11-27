package com.example.sqlreports.languageReport;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository <LanguageEntity, String> {

    @Query("SELECT \n" +
            "    cl.Language,\n" +
            "    SUM(c.Population * cl.Percentage / 100) AS speakers, \n" +
            "    CONCAT(ROUND(SUM(c.Population * cl.Percentage / 100) / (SELECT SUM(Population) FROM country) * 100, 2), '%') AS percentage  \n" +
            "FROM country c\n" +
            "JOIN countrylanguage cl ON c.Code = cl.CountryCode\n" +
            "WHERE cl.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')  \n" +
            "GROUP BY cl.Language\n" +
            "ORDER BY speakers DESC")
    List<LanguageEntity> findLanguageSpeakersPercentage();
}
