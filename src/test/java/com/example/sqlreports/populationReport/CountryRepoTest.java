package com.example.sqlreports.populationReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "/test-data.sql") // Shared script for country and city test data
class CountryRepoTest {

    @Autowired
    private CountryRepo countryRepo;

    @BeforeEach
    void setUp() {
        // Test data is loaded using the @Sql annotation
    }

    @Test
    void testFindPopulationInCountryFiltered() {
        List<Country> result = countryRepo.findPopulationInCountryFiltered();

        assertNotNull(result);
        assertEquals(3, result.size()); // Assuming 3 countries in the test data

        // Validate the first country (e.g., China)
        Country firstCountry = result.get(0);
        assertEquals("China", firstCountry.getCountry());
        assertEquals(1400000000L, firstCountry.getTotalPopulation().longValue()); // Use long for large numbers
        assertEquals(45000000L, firstCountry.getCityPopulation().longValue()); // Example city population
        assertEquals("3.21%", firstCountry.getCityPercentage()); // Example city percentage
        assertEquals(1355000000L, firstCountry.getRuralPopulation().longValue()); // Example rural population
        assertEquals("96.79%", firstCountry.getRuralPercentage()); // Example rural percentage

        // Validate the second country (e.g., India)
        Country secondCountry = result.get(1);
        assertEquals("India", secondCountry.getCountry());
        assertEquals(1300000000L, secondCountry.getTotalPopulation().longValue());
    }
}
