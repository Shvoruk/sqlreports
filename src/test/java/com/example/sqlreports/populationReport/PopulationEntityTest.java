package com.example.sqlreports.populationReport;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PopulationEntityTest {

    @Test
    void testPopulationEntitySettersAndGetters() {
        PopulationEntity populationEntity = new PopulationEntity();

        // Test the name property
        populationEntity.setName("India");
        assertEquals("India", populationEntity.getName());

        // Test the totalPopulation property
        BigDecimal totalPopulation = new BigDecimal("1400000000");
        populationEntity.setPopulation(totalPopulation);
        assertEquals(totalPopulation, populationEntity.getPopulation());
    }

    @Test
    void testDefaultValues() {
        PopulationEntity populationEntity = new PopulationEntity();

        // Test default values (should be null)
        assertNull(populationEntity.getName());
        assertNull(populationEntity.getPopulation());
    }
}
