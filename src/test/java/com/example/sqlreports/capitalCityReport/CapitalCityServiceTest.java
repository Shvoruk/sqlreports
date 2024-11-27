package com.example.sqlreports.capitalCityReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CapitalCityServiceTest {

    private CapitalCityService capitalCityService;

    @Mock
    private CapitalCityRepository capitalCityRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        capitalCityService = new CapitalCityService(capitalCityRepository);
    }

    @Test
    void testGetAllCapitalCitiesInWorld() {
        List<CapitalCityEntity> mockCities = Arrays.asList(
                new CapitalCityEntity() {{
                    setName("Washington, D.C.");
                    setCountry("United States");
                    setPopulation(705749);
                }},
                new CapitalCityEntity() {{
                    setName("Ottawa");
                    setCountry("Canada");
                    setPopulation(994837);
                }}
        );

        when(capitalCityRepository.findAllCapitalCitiesByWorldOrderedByPopulation()).thenReturn(mockCities);

        List<CapitalCityEntity> result = capitalCityService.getAllCapitalCitiesInWorld();

        assertEquals(2, result.size());
        assertEquals("Washington, D.C.", result.get(0).getName());
        assertEquals("Ottawa", result.get(1).getName());

        verify(capitalCityRepository, times(1)).findAllCapitalCitiesByWorldOrderedByPopulation();
    }

    @Test
    void testGetAllCapitalCitiesInContinent() {
        String continent = "North America";
        List<CapitalCityEntity> mockCities = Arrays.asList(
                new CapitalCityEntity() {{
                    setName("Washington, D.C.");
                    setCountry("United States");
                    setPopulation(705749);
                }},
                new CapitalCityEntity() {{
                    setName("Ottawa");
                    setCountry("Canada");
                    setPopulation(994837);
                }}
        );

        when(capitalCityRepository.findAllCapitalCitiesByContinentOrderedByPopulation(continent)).thenReturn(mockCities);

        List<CapitalCityEntity> result = capitalCityService.getAllCapitalCitiesInContinent(continent);

        assertEquals(2, result.size());
        assertEquals("Washington, D.C.", result.get(0).getName());
        assertEquals("Ottawa", result.get(1).getName());

        verify(capitalCityRepository, times(1)).findAllCapitalCitiesByContinentOrderedByPopulation(continent);
    }

    @Test
    void testGetAllCapitalCitiesInRegion() {
        String region = "Northern America";
        List<CapitalCityEntity> mockCities = Arrays.asList(
                new CapitalCityEntity() {{
                    setName("Washington, D.C.");
                    setCountry("United States");
                    setPopulation(705749);
                }},
                new CapitalCityEntity() {{
                    setName("Ottawa");
                    setCountry("Canada");
                    setPopulation(994837);
                }}
        );

        when(capitalCityRepository.findAllCapitalCitiesByRegionOrderedByPopulation(region)).thenReturn(mockCities);

        List<CapitalCityEntity> result = capitalCityService.getAllCapitalCitiesInRegion(region);

        assertEquals(2, result.size());
        assertEquals("Washington, D.C.", result.get(0).getName());
        assertEquals("Ottawa", result.get(1).getName());

        verify(capitalCityRepository, times(1)).findAllCapitalCitiesByRegionOrderedByPopulation(region);
    }

    @Test
    void testGetAllCapitalCitiesInWorldLimited() {
        int limit = 1;
        List<CapitalCityEntity> mockCities = Arrays.asList(
                new CapitalCityEntity() {{
                    setName("Washington, D.C.");
                    setCountry("United States");
                    setPopulation(705749);
                }}
        );

        when(capitalCityRepository.findAllCapitalCitiesWithLimitByWorldOrderedByPopulation(limit)).thenReturn(mockCities);

        List<CapitalCityEntity> result = capitalCityService.getAllCapitalCitiesInWorldLimited(limit);

        assertEquals(1, result.size());
        assertEquals("Washington, D.C.", result.get(0).getName());

        verify(capitalCityRepository, times(1)).findAllCapitalCitiesWithLimitByWorldOrderedByPopulation(limit);
    }

    @Test
    void testGetAllCapitalCitiesInContinentLimited() {
        String continent = "North America";
        int limit = 1;
        List<CapitalCityEntity> mockCities = Arrays.asList(
                new CapitalCityEntity() {{
                    setName("Washington, D.C.");
                    setCountry("United States");
                    setPopulation(705749);
                }}
        );

        when(capitalCityRepository.findAllCapitalCitiesWithLimitByContinentOrderedByPopulation(continent, limit)).thenReturn(mockCities);

        List<CapitalCityEntity> result = capitalCityService.getAllCapitalCitiesInContinentLimited(continent, limit);

        assertEquals(1, result.size());
        assertEquals("Washington, D.C.", result.get(0).getName());

        verify(capitalCityRepository, times(1)).findAllCapitalCitiesWithLimitByContinentOrderedByPopulation(continent, limit);
    }

    @Test
    void testGetAllCapitalCitiesInRegionLimited() {
        String region = "Northern America";
        int limit = 1;
        List<CapitalCityEntity> mockCities = Arrays.asList(
                new CapitalCityEntity() {{
                    setName("Washington, D.C.");
                    setCountry("United States");
                    setPopulation(705749);
                }}
        );

        when(capitalCityRepository.findAllCapitalCitiesWithLimitByRegionOrderedByPopulation(region, limit)).thenReturn(mockCities);

        List<CapitalCityEntity> result = capitalCityService.getAllCapitalCitiesInRegionLimited(region, limit);

        assertEquals(1, result.size());
        assertEquals("Washington, D.C.", result.get(0).getName());

        verify(capitalCityRepository, times(1)).findAllCapitalCitiesWithLimitByRegionOrderedByPopulation(region, limit);
    }
}
