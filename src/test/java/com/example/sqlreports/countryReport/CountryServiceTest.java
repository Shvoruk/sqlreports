package com.example.sqlreports.countryReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryService countryService;

    private List<CountryEntity> mockCountries;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        CountryEntity country1 = new CountryEntity();
        country1.setCode("C1");
        country1.setName("Country1");
        country1.setContinent("Continent1");
        country1.setRegion("Region1");
        country1.setPopulation(5000000);
        country1.setCapital(1);

        CountryEntity country2 = new CountryEntity();
        country2.setCode("C2");
        country2.setName("Country2");
        country2.setContinent("Continent2");
        country2.setRegion("Region2");
        country2.setPopulation(10000000);
        country2.setCapital(2);

        mockCountries = List.of(country1, country2);
    }

    @Test
    void testGetAllCountriesInWorld() {
        when(countryRepository.findAllCountriesByWorldOrderedByPopulation()).thenReturn(mockCountries);

        List<CountryEntity> result = countryService.getAllCountriesInWorld();

        assertEquals(mockCountries, result);
        verify(countryRepository).findAllCountriesByWorldOrderedByPopulation();
    }

    @Test
    void testGetAllCountriesInContinent() {
        when(countryRepository.findCountriesByContinentOrderedByPopulation("Continent1")).thenReturn(mockCountries);

        List<CountryEntity> result = countryService.getAllCountriesInContinent("Continent1");

        assertEquals(mockCountries, result);
        verify(countryRepository).findCountriesByContinentOrderedByPopulation("Continent1");
    }

    @Test
    void testGetAllCountriesInRegion() {
        when(countryRepository.findCountriesByRegionOrderedByPopulation("Region1")).thenReturn(mockCountries);

        List<CountryEntity> result = countryService.getAllCountriesInRegion("Region1");

        assertEquals(mockCountries, result);
        verify(countryRepository).findCountriesByRegionOrderedByPopulation("Region1");
    }

    @Test
    void testGetAllCountriesInWorldLimited() {
        when(countryRepository.findAllCountriesWithLimitByWorldOrderedByPopulation(2)).thenReturn(mockCountries);

        List<CountryEntity> result = countryService.getAllCountriesInWorldLimited(2);

        assertEquals(mockCountries, result);
        verify(countryRepository).findAllCountriesWithLimitByWorldOrderedByPopulation(2);
    }

    @Test
    void testGetAllCountriesInContinentLimited() {
        when(countryRepository.findCountriesWithLimitByContinentOrderedByPopulation("Continent1", 1)).thenReturn(List.of(mockCountries.get(0)));

        List<CountryEntity> result = countryService.getAllCountriesInContinentLimited("Continent1", 1);

        assertEquals(List.of(mockCountries.get(0)), result);
        verify(countryRepository).findCountriesWithLimitByContinentOrderedByPopulation("Continent1", 1);
    }

    @Test
    void testGetAllCountriesInRegionLimited() {
        when(countryRepository.findCountriesWithLimitByRegionOrderedByPopulation("Region1", 1)).thenReturn(List.of(mockCountries.get(0)));

        List<CountryEntity> result = countryService.getAllCountriesInRegionLimited("Region1", 1);

        assertEquals(List.of(mockCountries.get(0)), result);
        verify(countryRepository).findCountriesWithLimitByRegionOrderedByPopulation("Region1", 1);
    }
}
