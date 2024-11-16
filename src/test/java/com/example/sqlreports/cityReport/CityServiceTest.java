package com.example.sqlreports.cityReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    private List<CityEntity> mockCities;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        CityEntity city1 = new CityEntity();
        city1.setName("City1");
        city1.setCountry("Country1");
        city1.setDistrict("District1");
        city1.setPopulation(100000);

        CityEntity city2 = new CityEntity();
        city2.setName("City2");
        city2.setCountry("Country2");
        city2.setDistrict("District2");
        city2.setPopulation(200000);

        mockCities = List.of(city1, city2);
    }

    @Test
    void testGetAllCitiesInWorld() {
        when(cityRepository.findAllCitiesByWorldOrderedByPopulation()).thenReturn(mockCities);

        List<CityEntity> result = cityService.getAllCitiesInWorld();

        assertEquals(mockCities, result);
        verify(cityRepository).findAllCitiesByWorldOrderedByPopulation();
    }

    @Test
    void testGetAllCitiesInContinent() {
        when(cityRepository.findAllCitiesByContinentOrderedByPopulation("Asia")).thenReturn(mockCities);

        List<CityEntity> result = cityService.getAllCitiesInContinent("Asia");

        assertEquals(mockCities, result);
        verify(cityRepository).findAllCitiesByContinentOrderedByPopulation("Asia");
    }

    @Test
    void testGetAllCitiesInRegion() {
        when(cityRepository.findAllCitiesByRegionOrderedByPopulation("Midwest")).thenReturn(mockCities);

        List<CityEntity> result = cityService.getAllCitiesInRegion("Midwest");

        assertEquals(mockCities, result);
        verify(cityRepository).findAllCitiesByRegionOrderedByPopulation("Midwest");
    }

    @Test
    void testGetAllCitiesInCountry() {
        when(cityRepository.findAllCitiesByCountryOrderedByPopulation("Country1")).thenReturn(mockCities);

        List<CityEntity> result = cityService.getAllCitiesInCountry("Country1");

        assertEquals(mockCities, result);
        verify(cityRepository).findAllCitiesByCountryOrderedByPopulation("Country1");
    }

    @Test
    void testGetAllCitiesInDistrict() {
        when(cityRepository.findAllCitiesByDistrictOrderedByPopulation("District1")).thenReturn(mockCities);

        List<CityEntity> result = cityService.getAllCitiesInDistrict("District1");

        assertEquals(mockCities, result);
        verify(cityRepository).findAllCitiesByDistrictOrderedByPopulation("District1");
    }

    @Test
    void testGetAllCitiesInWorldLimited() {
        when(cityRepository.findCitiesWithLimitByWorldOrderedByPopulation(5)).thenReturn(mockCities);

        List<CityEntity> result = cityService.getAllCitiesInWorldLimited(5);

        assertEquals(mockCities, result);
        verify(cityRepository).findCitiesWithLimitByWorldOrderedByPopulation(5);
    }

    @Test
    void testGetAllCitiesInContinentLimited() {
        when(cityRepository.findCitiesWithLimitByContinentOrderedByPopulation("Asia", 3)).thenReturn(mockCities);

        List<CityEntity> result = cityService.getAllCitiesInContinentLimited("Asia", 3);

        assertEquals(mockCities, result);
        verify(cityRepository).findCitiesWithLimitByContinentOrderedByPopulation("Asia", 3);
    }

    @Test
    void testGetAllCitiesInRegionLimited() {
        when(cityRepository.findCitiesWithLimitByRegionOrderedByPopulation("Midwest", 2)).thenReturn(mockCities);

        List<CityEntity> result = cityService.getAllCitiesInRegionLimited("Midwest", 2);

        assertEquals(mockCities, result);
        verify(cityRepository).findCitiesWithLimitByRegionOrderedByPopulation("Midwest", 2);
    }

    @Test
    void testGetAllCitiesInCountryLimited() {
        when(cityRepository.findCitiesWithLimitByCountryOrderedByPopulation("Country1", 4)).thenReturn(mockCities);

        List<CityEntity> result = cityService.getAllCitiesInCountryLimited("Country1", 4);

        assertEquals(mockCities, result);
        verify(cityRepository).findCitiesWithLimitByCountryOrderedByPopulation("Country1", 4);
    }

    @Test
    void testGetAllCitiesInDistrictLimited() {
        when(cityRepository.findCitiesWithLimitByDistrictOrderedByPopulation("District1", 1)).thenReturn(mockCities);

        List<CityEntity> result = cityService.getAllCitiesInDistrictLimited("District1", 1);

        assertEquals(mockCities, result);
        verify(cityRepository).findCitiesWithLimitByDistrictOrderedByPopulation("District1", 1);
    }
}
