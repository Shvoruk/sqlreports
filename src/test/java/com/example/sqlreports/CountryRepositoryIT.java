package com.example.sqlreports;

import com.example.sqlreports.countryReport.CountryEntity;
import com.example.sqlreports.countryReport.CountryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("integration")
@SpringBootTest
public class CountryRepositoryIT {

    @Autowired
    CountryRepository countryRepository;

    @Test
    void testFindAllCountriesByWorldOrderedByPopulation() {

        // Act: Retrieve data from the database using the method
        List<CountryEntity> countries = countryRepository.findAllCountriesByWorldOrderedByPopulation();

        // Assert: Validate the data is ordered by population in descending order
        Assertions.assertThat(countries).isNotEmpty(); // Ensure the list is not empty

        // Validate specific details about the retrieved data (adjust based on your database's content)
        CountryEntity mostPopulousCountry = countries.get(0);
        Assertions.assertThat(mostPopulousCountry.getName()).isEqualTo("China"); // Example
        Assertions.assertThat(mostPopulousCountry.getPopulation()).isEqualTo(1277558000);

        // Check ordering (each country's population should be greater or equal to the next)
        for (int i = 0; i < countries.size() - 1; i++) {
            Assertions.assertThat(countries.get(i).getPopulation())
                    .isGreaterThanOrEqualTo(countries.get(i + 1).getPopulation());
        }
    }
}