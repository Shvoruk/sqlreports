package com.example.sqlreports.countryReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    private List<CountryEntity> mockCountries;

    @BeforeEach
    void setUp() {
        mockCountries = Arrays.asList(
                new CountryEntity() {{
                    setName("USA");
                    setPopulation(331000000);
                }},
                new CountryEntity() {{
                    setName("Canada");
                    setPopulation(38000000);
                }}
        );
    }

    @Test
    void testGetCountriesInTheWorldWithoutLimit() throws Exception {
        when(countryService.getAllCountriesInWorld()).thenReturn(mockCountries);

        mockMvc.perform(get("/countries/world"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("USA")))
                .andExpect(jsonPath("$[1].name", is("Canada")));

        verify(countryService, times(1)).getAllCountriesInWorld();
        verifyNoMoreInteractions(countryService);
    }

    @Test
    void testGetCountriesInTheWorldWithLimit() throws Exception {
        when(countryService.getAllCountriesInWorldLimited(1)).thenReturn(mockCountries.subList(0, 1));

        mockMvc.perform(get("/countries/world").param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1)))
                .andExpect(jsonPath("$[0].name", is("USA")));

        verify(countryService, times(1)).getAllCountriesInWorldLimited(1);
        verifyNoMoreInteractions(countryService);
    }

    @Test
    void testGetCountriesInTheContinentWithoutLimit() throws Exception {
        String continent = "North America";
        when(countryService.getAllCountriesInContinent(continent)).thenReturn(mockCountries);

        mockMvc.perform(get("/countries/continent").param("continent", continent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("USA")))
                .andExpect(jsonPath("$[1].name", is("Canada")));

        verify(countryService, times(1)).getAllCountriesInContinent(continent);
        verifyNoMoreInteractions(countryService);
    }

    @Test
    void testGetCountriesInTheContinentWithLimit() throws Exception {
        String continent = "North America";
        when(countryService.getAllCountriesInContinentLimited(continent, 1)).thenReturn(mockCountries.subList(0, 1));

        mockMvc.perform(get("/countries/continent")
                        .param("continent", continent)
                        .param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1)))
                .andExpect(jsonPath("$[0].name", is("USA")));

        verify(countryService, times(1)).getAllCountriesInContinentLimited(continent, 1);
        verifyNoMoreInteractions(countryService);
    }

    @Test
    void testGetCountriesInTheRegionWithoutLimit() throws Exception {
        String region = "South East";
        when(countryService.getAllCountriesInRegion(region)).thenReturn(mockCountries);

        mockMvc.perform(get("/countries/region").param("region", region))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("USA")))
                .andExpect(jsonPath("$[1].name", is("Canada")));

        verify(countryService, times(1)).getAllCountriesInRegion(region);
        verifyNoMoreInteractions(countryService);
    }

    @Test
    void testGetCountriesInTheRegionWithLimit() throws Exception {
        String region = "South East";
        when(countryService.getAllCountriesInRegionLimited(region, 1)).thenReturn(mockCountries.subList(0, 1));

        mockMvc.perform(get("/countries/region")
                        .param("region", region)
                        .param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1)))
                .andExpect(jsonPath("$[0].name", is("USA")));

        verify(countryService, times(1)).getAllCountriesInRegionLimited(region, 1);
        verifyNoMoreInteractions(countryService);
    }
}
