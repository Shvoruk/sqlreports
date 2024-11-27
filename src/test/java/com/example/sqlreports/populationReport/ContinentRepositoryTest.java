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

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "/test-data.sql") // Shared test data for countries and cities
class ContinentRepositoryTest {

    @Autowired
    private ContinentRepository continentRepository;

    @BeforeEach
    void setUp() {
        // Data is loaded via @Sql script
    }

    @Test
    void testFindPopulationInContinentFiltered() {
        List<Continent> result = continentRepository.findPopulationInContinentFiltered();

        assertNotNull(result);
        assertEquals(3, result.size()); // Assuming 3 continents in the test data

        Continent firstContinent = result.get(0);
        assertEquals("Asia", firstContinent.getContinent());
        assertEquals(5400000000L, firstContinent.getTotalPopulation().longValue()); // Use 'longValue()' for large numbers
        assertEquals(93000000L, firstContinent.getCityPopulation().longValue()); // Use 'longValue()'
        assertEquals("66.67%", firstContinent.getCityPercentage());
        assertEquals(900000000L, firstContinent.getRuralPopulation().longValue()); // Use 'longValue()'
        assertEquals("33.33%", firstContinent.getRuralPercentage());

        Continent secondContinent = result.get(1);
        assertEquals("Europe", secondContinent.getContinent());
        assertEquals(800000000L, secondContinent.getTotalPopulation().longValue()); // Use 'longValue()'
        assertEquals(500000000L, secondContinent.getCityPopulation().longValue()); // Use 'longValue()'
        assertEquals("62.50%", secondContinent.getCityPercentage());
        assertEquals(300000000L, secondContinent.getRuralPopulation().longValue()); // Use 'longValue()'
        assertEquals("37.50%", secondContinent.getRuralPercentage());
    }
}
