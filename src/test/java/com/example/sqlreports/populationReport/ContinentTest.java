package com.example.sqlreports.populationReport;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContinentTest {

    @Test
    void testContinentSettersAndGetters() {
        Continent continent = new Continent();

        // Test the continent property
        continent.setContinent("Asia");
        assertEquals("Asia", continent.getContinent());

        // Test the totalPopulation property
        BigDecimal totalPopulation = new BigDecimal("4500000000");
        continent.setTotalPopulation(totalPopulation);
        assertEquals(totalPopulation, continent.getTotalPopulation());

        // Test the cityPopulation property
        BigDecimal cityPopulation = new BigDecimal("2500000000");
        continent.setCityPopulation(cityPopulation);
        assertEquals(cityPopulation, continent.getCityPopulation());

        // Test the cityPercentage property
        String cityPercentage = "55.56%";
        continent.setCityPercentage(cityPercentage);
        assertEquals(cityPercentage, continent.getCityPercentage());

        // Test the ruralPopulation property
        BigDecimal ruralPopulation = new BigDecimal("2000000000");
        continent.setRuralPopulation(ruralPopulation);
        assertEquals(ruralPopulation, continent.getRuralPopulation());

        // Test the ruralPercentage property
        String ruralPercentage = "44.44%";
        continent.setRuralPercentage(ruralPercentage);
        assertEquals(ruralPercentage, continent.getRuralPercentage());
    }

    @Test
    void testDefaultValues() {
        Continent continent = new Continent();

        // Test default values (should be null)
        assertNull(continent.getContinent());
        assertNull(continent.getTotalPopulation());
        assertNull(continent.getCityPopulation());
        assertNull(continent.getCityPercentage());
        assertNull(continent.getRuralPopulation());
        assertNull(continent.getRuralPercentage());
    }
}
