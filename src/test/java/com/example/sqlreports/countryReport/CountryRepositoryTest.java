package com.example.sqlreports.countryReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = "/test-data-country.sql") // Load test data for countries and cities
class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @BeforeEach
    void setUp() {
        // Test data is loaded via @Sql annotation
    }

    @Test
    void testFindAllCountriesByWorldOrderedByPopulation() {
        List<CountryEntity> result = countryRepository.findAllCountriesByWorldOrderedByPopulation();

        assertNotNull(result);
        assertEquals(3, result.size()); // Assuming 3 countries in test data
        assertEquals("Country A", result.get(0).getName());
        assertEquals(1400000000, result.get(0).getPopulation());
        assertEquals("City A", result.get(0).getCapital());
    }

    @Test
    void testFindCountriesByContinentOrderedByPopulation() {
        List<CountryEntity> result = countryRepository.findCountriesByContinentOrderedByPopulation("Asia");

        assertNotNull(result);
        assertEquals(2, result.size()); // Assuming 2 countries in Asia
        assertEquals("Country A", result.get(0).getName());
        assertEquals("Country B", result.get(1).getName());
    }

    @Test
    void testFindCountriesByRegionOrderedByPopulation() {
        List<CountryEntity> result = countryRepository.findCountriesByRegionOrderedByPopulation("South Asia");

        assertNotNull(result);
        assertEquals(1, result.size()); // Assuming 1 country in South Asia
        assertEquals("Country A", result.get(0).getName());
    }

    @Test
    void testFindAllCountriesWithLimitByWorldOrderedByPopulation() {
        List<CountryEntity> result = countryRepository.findAllCountriesWithLimitByWorldOrderedByPopulation(2);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Country A", result.get(0).getName());
        assertEquals("Country B", result.get(1).getName());
    }

    @Test
    void testFindCountriesWithLimitByContinentOrderedByPopulation() {
        List<CountryEntity> result = countryRepository.findCountriesWithLimitByContinentOrderedByPopulation("Asia", 1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Country A", result.get(0).getName());
    }

    @Test
    void testFindCountriesWithLimitByRegionOrderedByPopulation() {
        List<CountryEntity> result = countryRepository.findCountriesWithLimitByRegionOrderedByPopulation("South Asia", 1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Country A", result.get(0).getName());
    }
}
