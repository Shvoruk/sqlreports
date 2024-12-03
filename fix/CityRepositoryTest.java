package com.example.sqlreports.cityReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "/test-data.sql")
class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @BeforeEach
    void setUp() {
        // Test data is loaded via @Sql annotation
    }

    @Test
    void testFindAllCitiesByWorldOrderedByPopulation() {
        List<CityEntity> result = cityRepository.findAllCitiesByWorldOrderedByPopulation();

        assertNotNull(result);
        assertEquals(3, result.size()); // Assuming 3 cities in test data
        assertEquals("City A", result.get(0).getName());
        assertEquals(1000000, result.get(0).getPopulation());
    }

    @Test
    void testFindAllCitiesByContinentOrderedByPopulation() {
        List<CityEntity> result = cityRepository.findAllCitiesByContinentOrderedByPopulation("Asia");

        assertNotNull(result);
        assertEquals(2, result.size()); // Assuming 2 cities in Asia
        assertEquals("City B", result.get(0).getName());
    }

    @Test
    void testFindAllCitiesByCountryOrderedByPopulation() {
        List<CityEntity> result = cityRepository.findAllCitiesByCountryOrderedByPopulation("Country A");

        assertNotNull(result);
        assertEquals(2, result.size()); // Assuming 2 cities in Country A
        assertEquals("City C", result.get(0).getName());
    }

    @Test
    void testFindAllCitiesByRegionOrderedByPopulation() {
        List<CityEntity> result = cityRepository.findAllCitiesByRegionOrderedByPopulation("South Asia");

        assertNotNull(result);
        assertEquals(1, result.size()); // Assuming 1 city in South Asia
        assertEquals("City D", result.get(0).getName());
    }

    @Test
    void testFindAllCitiesByDistrictOrderedByPopulation() {
        List<CityEntity> result = cityRepository.findAllCitiesByDistrictOrderedByPopulation("District A");

        assertNotNull(result);
        assertEquals(1, result.size()); // Assuming 1 city in District A
        assertEquals("City E", result.get(0).getName());
    }

    @Test
    void testFindCitiesWithLimitByWorldOrderedByPopulation() {
        List<CityEntity> result = cityRepository.findCitiesWithLimitByWorldOrderedByPopulation(2);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("City A", result.get(0).getName());
    }

    @Test
    void testFindCitiesWithLimitByContinentOrderedByPopulation() {
        List<CityEntity> result = cityRepository.findCitiesWithLimitByContinentOrderedByPopulation("Asia", 1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("City B", result.get(0).getName());
    }

    @Test
    void testFindCitiesWithLimitByRegionOrderedByPopulation() {
        List<CityEntity> result = cityRepository.findCitiesWithLimitByRegionOrderedByPopulation("South Asia", 1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("City D", result.get(0).getName());
    }

    @Test
    void testFindCitiesWithLimitByCountryOrderedByPopulation() {
        List<CityEntity> result = cityRepository.findCitiesWithLimitByCountryOrderedByPopulation("Country A", 1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("City C", result.get(0).getName());
    }

    @Test
    void testFindCitiesWithLimitByDistrictOrderedByPopulation() {
        List<CityEntity> result = cityRepository.findCitiesWithLimitByDistrictOrderedByPopulation("District A", 1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("City E", result.get(0).getName());
    }
}
