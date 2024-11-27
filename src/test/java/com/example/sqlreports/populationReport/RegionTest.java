package com.example.sqlreports.populationReport;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class RegionTest {

    @Test
    void testRegionSettersAndGetters() {
        Region region = new Region();

        // Test the region property
        region.setRegion("South Asia");
        assertEquals("South Asia", region.getRegion());

        // Test the totalPopulation property
        BigInteger totalPopulation = new BigInteger("1800000000");
        region.setTotalPopulation(totalPopulation);
        assertEquals(totalPopulation, region.getTotalPopulation());

        // Test the cityPopulation property
        BigInteger cityPopulation = new BigInteger("900000000");
        region.setCityPopulation(cityPopulation);
        assertEquals(cityPopulation, region.getCityPopulation());

        // Test the cityPercentage property
        String cityPercentage = "50.0%";
        region.setCityPercentage(cityPercentage);
        assertEquals(cityPercentage, region.getCityPercentage());

        // Test the ruralPopulation property
        BigInteger ruralPopulation = new BigInteger("900000000");
        region.setRuralPopulation(ruralPopulation);
        assertEquals(ruralPopulation, region.getRuralPopulation());

        // Test the ruralPercentage property
        String ruralPercentage = "50.0%";
        region.setRuralPercentage(ruralPercentage);
        assertEquals(ruralPercentage, region.getRuralPercentage());
    }

    @Test
    void testDefaultValues() {
        Region region = new Region();

        // Test default values (should be null)
        assertNull(region.getRegion());
        assertNull(region.getTotalPopulation());
        assertNull(region.getCityPopulation());
        assertNull(region.getCityPercentage());
        assertNull(region.getRuralPopulation());
        assertNull(region.getRuralPercentage());
    }
}
