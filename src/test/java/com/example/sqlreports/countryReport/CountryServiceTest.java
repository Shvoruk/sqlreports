package com.example.sqlreports.countryReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CountryServiceTest {

    private CountryService countryService;

    @Mock
    private CountryRepository countryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        countryService = new CountryService(countryRepository);
    }

    @Test
    void testGetAllCountriesInWorld() {
        List<CountryEntity> mockCountries = Arrays.asList(
                new CountryEntity() {{
                    setName("United States");
                    setPopulation(331000000);
                }},
                new CountryEntity() {{
                    setName("Canada");
                    setPopulation(38000000);
                }}
        );

        when(countryRepository.findAllCountriesByWorldOrderedByPopulation()).thenReturn(mockCountries);

        List<CountryEntity> result = countryService.getAllCountriesInWorld();

        assertEquals(2, result.size());
        assertEquals("United States", result.get(0).getName());
        assertEquals("Canada", result.get(1).getName());

        verify(countryRepository, times(1)).findAllCountriesByWorldOrderedByPopulation();
    }

    @Test
    void testGetAllCountriesInContinent() {
        String continent = "North America";
        List<CountryEntity> mockCountries = Arrays.asList(
                new CountryEntity() {{
                    setName("United States");
                    setPopulation(331000000);
                }},
                new CountryEntity() {{
                    setName("Canada");
                    setPopulation(38000000);
                }}
        );

        when(countryRepository.findCountriesByContinentOrderedByPopulation(continent)).thenReturn(mockCountries);

        List<CountryEntity> result = countryService.getAllCountriesInContinent(continent);

        assertEquals(2, result.size());
        assertEquals("United States", result.get(0).getName());
        assertEquals("Canada", result.get(1).getName());

        verify(countryRepository, times(1)).findCountriesByContinentOrderedByPopulation(continent);
    }

    @Test
    void testGetAllCountriesInRegion() {
        String region = "Northern America";
        List<CountryEntity> mockCountries = Arrays.asList(
                new CountryEntity() {{
                    setName("United States");
                    setPopulation(331000000);
                }},
                new CountryEntity() {{
                    setName("Canada");
                    setPopulation(38000000);
                }}
        );

        when(countryRepository.findCountriesByRegionOrderedByPopulation(region)).thenReturn(mockCountries);

        List<CountryEntity> result = countryService.getAllCountriesInRegion(region);

        assertEquals(2, result.size());
        assertEquals("United States", result.get(0).getName());
        assertEquals("Canada", result.get(1).getName());

        verify(countryRepository, times(1)).findCountriesByRegionOrderedByPopulation(region);
    }

    @Test
    void testGetAllCountriesInWorldLimited() {
        int limit = 1;
        List<CountryEntity> mockCountries = Arrays.asList(
                new CountryEntity() {{
                    setName("United States");
                    setPopulation(331000000);
                }}
        );

        when(countryRepository.findAllCountriesWithLimitByWorldOrderedByPopulation(limit)).thenReturn(mockCountries);

        List<CountryEntity> result = countryService.getAllCountriesInWorldLimited(limit);

        assertEquals(1, result.size());
        assertEquals("United States", result.get(0).getName());

        verify(countryRepository, times(1)).findAllCountriesWithLimitByWorldOrderedByPopulation(limit);
    }

    @Test
    void testGetAllCountriesInContinentLimited() {
        String continent = "North America";
        int limit = 1;
        List<CountryEntity> mockCountries = Arrays.asList(
                new CountryEntity() {{
                    setName("United States");
                    setPopulation(331000000);
                }}
        );

        when(countryRepository.findCountriesWithLimitByContinentOrderedByPopulation(continent, limit)).thenReturn(mockCountries);

        List<CountryEntity> result = countryService.getAllCountriesInContinentLimited(continent, limit);

        assertEquals(1, result.size());
        assertEquals("United States", result.get(0).getName());

        verify(countryRepository, times(1)).findCountriesWithLimitByContinentOrderedByPopulation(continent, limit);
    }

    @Test
    void testGetAllCountriesInRegionLimited() {
        String region = "Northern America";
        int limit = 1;
        List<CountryEntity> mockCountries = Arrays.asList(
                new CountryEntity() {{
                    setName("United States");
                    setPopulation(331000000);
                }}
        );

        when(countryRepository.findCountriesWithLimitByRegionOrderedByPopulation(region, limit)).thenReturn(mockCountries);

        List<CountryEntity> result = countryService.getAllCountriesInRegionLimited(region, limit);

        assertEquals(1, result.size());
        assertEquals("United States", result.get(0).getName());

        verify(countryRepository, times(1)).findCountriesWithLimitByRegionOrderedByPopulation(region, limit);
    }
}
