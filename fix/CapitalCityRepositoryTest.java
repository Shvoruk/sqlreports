package com.example.sqlreports.capitalCityReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "/test-data.sql")
class CapitalCityRepositoryTest {

    @Autowired
    private CapitalCityRepository capitalCityRepository;

    @BeforeEach
    void setUp() {
        // Data setup happens through @Sql annotation
    }

    @Test
    void testFindAllCapitalCitiesByWorldOrderedByPopulation() {
        List<CapitalCityEntity> result = capitalCityRepository.findAllCapitalCitiesByWorldOrderedByPopulation();

        assertNotNull(result);
        assertEquals(3, result.size()); // Assuming 3 capital cities in test data
        assertEquals("City A", result.get(0).getName()); // Check first city's name
    }

    @Test
    void testFindAllCapitalCitiesByContinentOrderedByPopulation() {
        List<CapitalCityEntity> result = capitalCityRepository.findAllCapitalCitiesByContinentOrderedByPopulation("Asia");

        assertNotNull(result);
        assertEquals(2, result.size()); // Assuming 2 capital cities in Asia in test data
        assertEquals("City B", result.get(0).getName());
    }

    @Test
    void testFindAllCapitalCitiesByRegionOrderedByPopulation() {
        List<CapitalCityEntity> result = capitalCityRepository.findAllCapitalCitiesByRegionOrderedByPopulation("South Asia");

        assertNotNull(result);
        assertEquals(1, result.size()); // Assuming 1 capital city in South Asia in test data
        assertEquals("City C", result.get(0).getName());
    }

    @Test
    void testFindAllCapitalCitiesWithLimitByWorldOrderedByPopulation() {
        List<CapitalCityEntity> result = capitalCityRepository.findAllCapitalCitiesWithLimitByWorldOrderedByPopulation(2);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("City A", result.get(0).getName());
        assertEquals("City B", result.get(1).getName());
    }

    @Test
    void testFindAllCapitalCitiesWithLimitByContinentOrderedByPopulation() {
        List<CapitalCityEntity> result = capitalCityRepository.findAllCapitalCitiesWithLimitByContinentOrderedByPopulation("Asia", 1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("City B", result.get(0).getName());
    }

    @Test
    void testFindAllCapitalCitiesWithLimitByRegionOrderedByPopulation() {
        List<CapitalCityEntity> result = capitalCityRepository.findAllCapitalCitiesWithLimitByRegionOrderedByPopulation("South Asia", 1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("City C", result.get(0).getName());
    }
}
