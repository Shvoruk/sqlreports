package com.example.sqlreports.countryReport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountryEntityTest {

    @Test
    void testCountryEntitySettersAndGetters() {
        CountryEntity country = new CountryEntity();

        // Test the code property
        country.setCode("US");
        assertEquals("US", country.getCode());

        // Test the name property
        country.setName("United States");
        assertEquals("United States", country.getName());

        // Test the continent property
        country.setContinent("North America");
        assertEquals("North America", country.getContinent());

        // Test the region property
        country.setRegion("Northern America");
        assertEquals("Northern America", country.getRegion());

        // Test the population property
        country.setPopulation(331000000);
        assertEquals(331000000, country.getPopulation());

        // Test the capital property
        country.setCapital("Washington, D.C.");
        assertEquals("Washington, D.C.", country.getCapital());
    }

    @Test
    void testCountryEntityDefaultValues() {
        CountryEntity country = new CountryEntity();

        // Test default values (should be null for strings and Integer)
        assertNull(country.getCode());
        assertNull(country.getName());
        assertNull(country.getContinent());
        assertNull(country.getRegion());
        assertNull(country.getPopulation());
        assertNull(country.getCapital());
    }
}
