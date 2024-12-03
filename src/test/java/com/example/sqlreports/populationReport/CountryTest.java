package com.example.sqlreports.populationReport;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void testCountrySettersAndGetters() {
        Country country = new Country();

        // Test the country property
        country.setCountry("India");
        assertEquals("India", country.getCountry());

        // Test the totalPopulation property
        BigInteger totalPopulation = new BigInteger("1400000000");
        country.setTotalPopulation(totalPopulation);
        assertEquals(totalPopulation, country.getTotalPopulation());

        // Test the cityPopulation property
        BigInteger cityPopulation = new BigInteger("600000000");
        country.setCityPopulation(cityPopulation);
        assertEquals(cityPopulation, country.getCityPopulation());

        // Test the cityPercentage property
        String cityPercentage = "42.86%";
        country.setCityPercentage(cityPercentage);
        assertEquals(cityPercentage, country.getCityPercentage());

        // Test the ruralPopulation property
        BigInteger ruralPopulation = new BigInteger("800000000");
        country.setRuralPopulation(ruralPopulation);
        assertEquals(ruralPopulation, country.getRuralPopulation());

        // Test the ruralPercentage property
        String ruralPercentage = "57.14%";
        country.setRuralPercentage(ruralPercentage);
        assertEquals(ruralPercentage, country.getRuralPercentage());
    }

    @Test
    void testDefaultValues() {
        Country country = new Country();

        // Test default values (should be null)
        assertNull(country.getCountry());
        assertNull(country.getTotalPopulation());
        assertNull(country.getCityPopulation());
        assertNull(country.getCityPercentage());
        assertNull(country.getRuralPopulation());
        assertNull(country.getRuralPercentage());
    }
}
