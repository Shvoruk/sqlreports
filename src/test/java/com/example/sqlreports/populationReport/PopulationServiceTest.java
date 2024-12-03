package com.example.sqlreports.populationReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PopulationServiceTest {

    private PopulationService populationService;

    @Mock
    private CountryRepo countryRepository;

    @Mock
    private RegionRepository regionRepository;

    @Mock
    private ContinentRepository continentRepository;

    @Mock
    private PopulationRepository populationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        populationService = new PopulationService(countryRepository, regionRepository, continentRepository, populationRepository);
    }

    @Test
    void testGetCountriesFiltered() {
        List<Country> mockCountries = Arrays.asList(
                createCountry("India", new BigInteger("1400000000")),
                createCountry("USA", new BigInteger("331000000"))
        );

        when(countryRepository.findPopulationInCountryFiltered()).thenReturn(mockCountries);

        List<Country> result = populationService.getCountriesFiltered();

        assertEquals(2, result.size());
        assertEquals("India", result.get(0).getCountry());
        assertEquals(new BigInteger("1400000000"), result.get(0).getTotalPopulation());

        verify(countryRepository, times(1)).findPopulationInCountryFiltered();
    }

    @Test
    void testGetRegionsFiltered() {
        List<Region> mockRegions = Arrays.asList(
                createRegion("South Asia", new BigInteger("1800000000")),
                createRegion("Northern America", new BigInteger("350000000"))
        );

        when(regionRepository.findPopulationInRegionFiltered()).thenReturn(mockRegions);

        List<Region> result = populationService.getRegionsFiltered();

        assertEquals(2, result.size());
        assertEquals("South Asia", result.get(0).getRegion());
        assertEquals(new BigInteger("1800000000"), result.get(0).getTotalPopulation());

        verify(regionRepository, times(1)).findPopulationInRegionFiltered();
    }

    @Test
    void testGetContinentsFiltered() {
        List<Continent> mockContinents = Arrays.asList(
                createContinent("Asia", new BigDecimal("4500000000")),
                createContinent("Europe", new BigDecimal("750000000"))
        );

        when(continentRepository.findPopulationInContinentFiltered()).thenReturn(mockContinents);

        List<Continent> result = populationService.getContinentsFiltered();

        assertEquals(2, result.size());
        assertEquals("Asia", result.get(0).getContinent());
        assertEquals(new BigDecimal("4500000000"), result.get(0).getTotalPopulation());

        verify(continentRepository, times(1)).findPopulationInContinentFiltered();
    }

    @Test
    void testGetPopulationInWorld() {
        List<PopulationEntity> mockPopulation = Arrays.asList(
                createPopulationEntity("World", new BigDecimal("8000000000"))
        );

        when(populationRepository.findPopulationInWorld()).thenReturn(mockPopulation);

        List<PopulationEntity> result = populationService.getPopulationInWorld();

        assertEquals(1, result.size());
        assertEquals("World", result.get(0).getName());
        assertEquals(new BigDecimal("8000000000"), result.get(0).getPopulation());

        verify(populationRepository, times(1)).findPopulationInWorld();
    }

    @Test
    void testGetPopulationInContinent() {
        String continent = "Asia";
        List<PopulationEntity> mockPopulation = Arrays.asList(
                createPopulationEntity(continent, new BigDecimal("4500000000"))
        );

        when(populationRepository.findPopulationInContinent(continent)).thenReturn(mockPopulation);

        List<PopulationEntity> result = populationService.getPopulationInContinent(continent);

        assertEquals(1, result.size());
        assertEquals("Asia", result.get(0).getName());
        assertEquals(new BigDecimal("4500000000"), result.get(0).getPopulation());

        verify(populationRepository, times(1)).findPopulationInContinent(continent);
    }

    private Country createCountry(String name, BigInteger population) {
        Country country = new Country();
        country.setCountry(name);
        country.setTotalPopulation(population);
        return country;
    }

    private Region createRegion(String name, BigInteger population) {
        Region region = new Region();
        region.setRegion(name);
        region.setTotalPopulation(population);
        return region;
    }

    private Continent createContinent(String name, BigDecimal population) {
        Continent continent = new Continent();
        continent.setContinent(name);
        continent.setTotalPopulation(population);
        return continent;
    }

    private PopulationEntity createPopulationEntity(String name, BigDecimal population) {
        PopulationEntity entity = new PopulationEntity();
        entity.setName(name);
        entity.setPopulation(population);
        return entity;
    }
}
