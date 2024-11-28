package com.example.sqlreports.capitalCityReport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalCityEntityTest {

    @Test
    void testCapitalCityEntitySettersAndGetters() {
        CapitalCityEntity capitalCity = new CapitalCityEntity();

        // Test the name property
        capitalCity.setName("Washington, D.C.");
        assertEquals("Washington, D.C.", capitalCity.getName());

        // Test the country property
        capitalCity.setCountry("United States");
        assertEquals("United States", capitalCity.getCountry());

        // Test the population property
        capitalCity.setPopulation(705749);
        assertEquals(705749, capitalCity.getPopulation());
    }

    @Test
    void testCapitalCityEntityDefaultValues() {
        CapitalCityEntity capitalCity = new CapitalCityEntity();

        // Test default values (should be null for strings and Integer)
        assertNull(capitalCity.getName());
        assertNull(capitalCity.getCountry());
        assertNull(capitalCity.getPopulation());
    }
}
