package com.example.sqlreports.capitalCityReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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

@WebMvcTest(CapitalCityController.class)
class CapitalCityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CapitalCityService capitalCityService;

    private List<CapitalCityEntity> mockCapitalCities;

    @BeforeEach
    void setUp() {
        mockCapitalCities = Arrays.asList(
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
    }

    @Test
    void testGetCitiesInWorldWithoutLimit() throws Exception {
        when(capitalCityService.getAllCapitalCitiesInWorld()).thenReturn(mockCapitalCities);

        mockMvc.perform(get("/cities/capital/world"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("Washington, D.C.")))
                .andExpect(jsonPath("$[1].name", is("Ottawa")));

        verify(capitalCityService, times(1)).getAllCapitalCitiesInWorld();
        verifyNoMoreInteractions(capitalCityService);
    }

    @Test
    void testGetCitiesInWorldWithLimit() throws Exception {
        when(capitalCityService.getAllCapitalCitiesInWorldLimited(1)).thenReturn(mockCapitalCities.subList(0, 1));

        mockMvc.perform(get("/cities/capital/world").param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1)))
                .andExpect(jsonPath("$[0].name", is("Washington, D.C.")));

        verify(capitalCityService, times(1)).getAllCapitalCitiesInWorldLimited(1);
        verifyNoMoreInteractions(capitalCityService);
    }

    @Test
    void testGetCitiesInContinentWithoutLimit() throws Exception {
        String continent = "North America";
        when(capitalCityService.getAllCapitalCitiesInContinent(continent)).thenReturn(mockCapitalCities);

        mockMvc.perform(get("/cities/capital/continent").param("continent", continent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("Washington, D.C.")))
                .andExpect(jsonPath("$[1].name", is("Ottawa")));

        verify(capitalCityService, times(1)).getAllCapitalCitiesInContinent(continent);
        verifyNoMoreInteractions(capitalCityService);
    }

    @Test
    void testGetCitiesInContinentWithLimit() throws Exception {
        String continent = "North America";
        when(capitalCityService.getAllCapitalCitiesInContinentLimited(continent, 1)).thenReturn(mockCapitalCities.subList(0, 1));

        mockMvc.perform(get("/cities/capital/continent")
                        .param("continent", continent)
                        .param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1)))
                .andExpect(jsonPath("$[0].name", is("Washington, D.C.")));

        verify(capitalCityService, times(1)).getAllCapitalCitiesInContinentLimited(continent, 1);
        verifyNoMoreInteractions(capitalCityService);
    }

    @Test
    void testGetCitiesInRegionWithoutLimit() throws Exception {
        String region = "Northern America";
        when(capitalCityService.getAllCapitalCitiesInRegion(region)).thenReturn(mockCapitalCities);

        mockMvc.perform(get("/cities/capital/region").param("region", region))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("Washington, D.C.")))
                .andExpect(jsonPath("$[1].name", is("Ottawa")));

        verify(capitalCityService, times(1)).getAllCapitalCitiesInRegion(region);
        verifyNoMoreInteractions(capitalCityService);
    }

    @Test
    void testGetCitiesInRegionWithLimit() throws Exception {
        String region = "Northern America";
        when(capitalCityService.getAllCapitalCitiesInRegionLimited(region, 1)).thenReturn(mockCapitalCities.subList(0, 1));

        mockMvc.perform(get("/cities/capital/region")
                        .param("region", region)
                        .param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1)))
                .andExpect(jsonPath("$[0].name", is("Washington, D.C.")));

        verify(capitalCityService, times(1)).getAllCapitalCitiesInRegionLimited(region, 1);
        verifyNoMoreInteractions(capitalCityService);
    }
}
