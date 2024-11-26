package com.example.sqlreports.integrationTest;

import com.example.sqlreports.countryReport.CountryRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("integration")
@Sql(scripts = "/integration-test-data.sql")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegrationTest {

    @Autowired
    private CountryRepository countryRepository;

    @BeforeAll
    void setUp() {
        // Set up your MySQL or database connection here if needed.
        // In a real test case, Spring Boot will auto-configure the connection
    }

    @Test
    void testFindAllCountriesByWorldOrderedByPopulation() {
        // Perform the repository method and get result
        var countries = countryRepository.findAllCountriesByWorldOrderedByPopulation();

        // Test the result
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        assertEquals("China", countries.get(0).getName());
        assertEquals("United States", countries.get(1).getName());
    }

    @Test
    void testFindCountriesByContinent() {
        // Example to find countries by continent (e.g., North America)
        var countries = countryRepository.findCountriesByContinentOrderedByPopulation("North America");

        // Assert the results
        assertNotNull(countries);
        assertEquals(3, countries.size()); // Assuming there are 3 countries in North America
        assertEquals("United States", countries.get(0).getName());
    }

    @Test
    void testFindCountriesWithLimitByRegion() {
        // Example to find countries by region with limit (e.g., Americas, limit to 2)
        var countries = countryRepository.findCountriesWithLimitByRegionOrderedByPopulation("Americas", 2);

        // Assert the results
        assertNotNull(countries);
        assertEquals(2, countries.size());
        assertEquals("United States", countries.get(0).getName());
        assertEquals("Brazil", countries.get(1).getName());
    }
}
