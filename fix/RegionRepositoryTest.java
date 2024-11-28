package com.example.sqlreports.populationReport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "/test-data.sql")
class RegionRepositoryTest {

    @Autowired
    private RegionRepository regionRepository;

    @Test
    void testFindPopulationInRegionFiltered() {
        List<Region> result = regionRepository.findPopulationInRegionFiltered();

        assertNotNull(result);
        assertEquals(4, result.size()); // Adjusted to 4 regions

        for (Region region : result) {
            switch (region.getRegion()) {
                case "East Asia":
                    // China's data
                    assertEquals(2800000000L, region.getTotalPopulation().longValue());
                    assertEquals(45000000L, region.getCityPopulation().longValue());
                    assertEquals("1.61%", region.getCityPercentage());
                    assertEquals(2755000000L, region.getRuralPopulation().longValue());
                    assertEquals("98.39%", region.getRuralPercentage());
                    break;

                case "South Asia":
                    // India's data
                    assertEquals(2600000000L, region.getTotalPopulation().longValue());
                    assertEquals(48000000L, region.getCityPopulation().longValue());
                    assertEquals("1.85%", region.getCityPercentage());
                    assertEquals(2552000000L, region.getRuralPopulation().longValue());
                    assertEquals("96.31%", region.getRuralPercentage());
                    break;

                case "Western Europe":
                    // France's data
                    assertEquals(800000000L, region.getTotalPopulation().longValue());
                    assertEquals(5000000L, region.getCityPopulation().longValue());
                    assertEquals("0.63%", region.getCityPercentage());
                    assertEquals(795000000L, region.getRuralPopulation().longValue());
                    assertEquals("99.38%", region.getRuralPercentage());
                    break;

                case "Northern America":
                    // United States data
                    assertEquals(331000000L, region.getTotalPopulation().longValue());
                    assertEquals(8419600L, region.getCityPopulation().longValue());
                    assertEquals("2.54%", region.getCityPercentage());
                    assertEquals(322580400L, region.getRuralPopulation().longValue());
                    assertEquals("97.46%", region.getRuralPercentage());
                    break;

                default:
                    fail("Unexpected region: " + region.getRegion());
            }
        }
    }
}
