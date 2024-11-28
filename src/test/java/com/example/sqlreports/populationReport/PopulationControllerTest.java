package com.example.sqlreports.populationReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PopulationController.class)
class PopulationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PopulationService populationService;

    private List<Country> mockCountries;
    private List<Region> mockRegions;
    private List<Continent> mockContinents;
    private List<PopulationEntity> mockPopulation;

    @BeforeEach
    void setUp() {
        mockCountries = Arrays.asList(
                createCountry("India", new BigInteger("1400000000")),
                createCountry("USA", new BigInteger("331000000"))
        );

        mockRegions = Arrays.asList(
                createRegion("South Asia", new BigInteger("1800000000")),
                createRegion("Northern America", new BigInteger("350000000"))
        );

        mockContinents = Arrays.asList(
                createContinent("Asia", new BigDecimal("4500000000")),
                createContinent("Europe", new BigDecimal("750000000"))
        );

        mockPopulation = Arrays.asList(
                createPopulationEntity("World", new BigDecimal("8000000000"))
        );
    }

    @Test
    void testGetPopulationInContinentFiltered() throws Exception {
        when(populationService.getContinentsFiltered()).thenReturn(mockContinents);

        mockMvc.perform(get("/population/continent/filtered"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", equalTo(2)))
                .andExpect(jsonPath("$[0].continent", equalTo("Asia")))
                .andExpect(jsonPath("$[0].totalPopulation", equalTo(4500000000L)))
                .andExpect(jsonPath("$[1].continent", equalTo("Europe")))
                .andExpect(jsonPath("$[1].totalPopulation", equalTo(750000000))); // Remove 'L'

        verify(populationService, times(1)).getContinentsFiltered();
    }

    @Test
    void testGetPopulationInRegionFiltered() throws Exception {
        when(populationService.getRegionsFiltered()).thenReturn(mockRegions);

        mockMvc.perform(get("/population/region/filtered"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", equalTo(2)))
                .andExpect(jsonPath("$[0].region", equalTo("South Asia")))
                .andExpect(jsonPath("$[0].totalPopulation", equalTo(1800000000))) // Remove 'L'
                .andExpect(jsonPath("$[1].region", equalTo("Northern America")))
                .andExpect(jsonPath("$[1].totalPopulation", equalTo(350000000))); // Remove 'L'

        verify(populationService, times(1)).getRegionsFiltered();
    }

    @Test
    void testGetPopulationInCountryFiltered() throws Exception {
        when(populationService.getCountriesFiltered()).thenReturn(mockCountries);

        mockMvc.perform(get("/population/country/filtered"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", equalTo(2)))
                .andExpect(jsonPath("$[0].country", equalTo("India")))
                .andExpect(jsonPath("$[0].totalPopulation", equalTo(1400000000))) // Remove 'L'
                .andExpect(jsonPath("$[1].country", equalTo("USA")))
                .andExpect(jsonPath("$[1].totalPopulation", equalTo(331000000))); // Remove 'L'

        verify(populationService, times(1)).getCountriesFiltered();
    }

    @Test
    void testGetPopulationInWorld() throws Exception {
        when(populationService.getPopulationInWorld()).thenReturn(mockPopulation);

        mockMvc.perform(get("/population/world"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("World")))
                .andExpect(jsonPath("$[0].population", equalTo(8000000000L))); // Use 'L'

        verify(populationService, times(1)).getPopulationInWorld();
    }

    @Test
    void testGetPopulationInContinent() throws Exception {
        String continent = "Asia";
        when(populationService.getPopulationInContinent(continent)).thenReturn(mockPopulation);

        mockMvc.perform(get("/population/continent").param("continent", continent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("World")))
                .andExpect(jsonPath("$[0].population", equalTo(8000000000L))); // Use 'L'

        verify(populationService, times(1)).getPopulationInContinent(continent);
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
