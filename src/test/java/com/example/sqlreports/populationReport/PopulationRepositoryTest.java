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
@Sql(scripts = "/test-data.sql") // Shared SQL script for population data
class PopulationRepositoryTest {

    @Autowired
    private PopulationRepository populationRepository;

    @BeforeEach
    void setUp() {
        // Data is loaded using the @Sql annotation
    }

    @Test
    void testFindPopulationInWorld() {
        List<PopulationEntity> result = populationRepository.findPopulationInWorld();

        assertNotNull(result);
        assertEquals(1, result.size()); // Should return one aggregated value
        assertEquals(3531000000L, result.get(0).getPopulation().longValue()); // Sum of all populations
    }

    @Test
    void testFindPopulationInContinent() {
        List<PopulationEntity> result = populationRepository.findPopulationInContinent("Asia");

        assertNotNull(result);
        assertEquals(1, result.size()); // One aggregated result for continent
        assertEquals("Asia", result.get(0).getName());
        assertEquals(2700000000L, result.get(0).getPopulation().longValue());
    }

    @Test
    void testFindPopulationInCountry() {
        List<PopulationEntity> result = populationRepository.findPopulationInCountry("India");

        assertNotNull(result);
        assertEquals(1, result.size()); // One result for the country
        assertEquals("India", result.get(0).getName());
        assertEquals(1300000000L, result.get(0).getPopulation().longValue());
    }

    @Test
    void testFindPopulationInRegion() {
        List<PopulationEntity> result = populationRepository.findPopulationInRegion("South Asia");

        assertNotNull(result);
        assertEquals(1, result.size()); // One aggregated result for region
        assertEquals("South Asia", result.get(0).getName());
        assertEquals(2700000000L, result.get(0).getPopulation().longValue());
    }

    @Test
    void testFindPopulationInCity() {
        List<PopulationEntity> result = populationRepository.findPopulationInCity("Delhi");

        assertNotNull(result);
        assertEquals(1, result.size()); // One result for the city
        assertEquals("Delhi", result.get(0).getName());
        assertEquals(30000000L, result.get(0).getPopulation().longValue());
    }

    @Test
    void testFindPopulationInDistrict() {
        List<PopulationEntity> result = populationRepository.findPopulationInDistrict("District A");

        assertNotNull(result);
        assertEquals(1, result.size()); // Aggregated result for the district
        assertEquals("District A", result.get(0).getName());
        assertEquals(45000000L, result.get(0).getPopulation().longValue()); // Sum of all populations in District A
    }
}
