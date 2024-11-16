package com.example.sqlreports.cityReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CityController.class)
class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityService cityService;

    private List<CityEntity> mockCities;

    @BeforeEach
    void setUp() {
        // Set up mock city data
        CityEntity city1 = new CityEntity();
        city1.setName("City1");
        city1.setCountryCode("C1");
        city1.setDistrict("District1");
        city1.setPopulation(100000);

        CityEntity city2 = new CityEntity();
        city2.setName("City2");
        city2.setCountryCode("C2");
        city2.setDistrict("District2");
        city2.setPopulation(200000);

        mockCities = Arrays.asList(city1, city2);
    }

    @Test
    void testGetCitiesInWorld_NoLimit() throws Exception {
        when(cityService.getAllCitiesInWorld()).thenReturn(mockCities);

        mockMvc.perform(get("/cities/world"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("City1"))
                .andExpect(jsonPath("$[0].countryCode").value("C1"))
                .andExpect(jsonPath("$[0].district").value("District1"))
                .andExpect(jsonPath("$[0].population").value(100000))
                .andExpect(jsonPath("$[1].name").value("City2"))
                .andExpect(jsonPath("$[1].countryCode").value("C2"))
                .andExpect(jsonPath("$[1].district").value("District2"))
                .andExpect(jsonPath("$[1].population").value(200000));
    }

    @Test
    void testGetCitiesInWorld_WithLimit() throws Exception {
        when(cityService.getAllCitiesInWorldLimited(anyInt())).thenReturn(Collections.singletonList(mockCities.get(0)));

        mockMvc.perform(get("/cities/world").param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("City1"));
    }

    @Test
    void testGetCitiesInContinent_NoLimit() throws Exception {
        when(cityService.getAllCitiesInContinent(anyString())).thenReturn(mockCities);

        mockMvc.perform(get("/cities/continent").param("continent", "Asia"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("City1"));
    }

    @Test
    void testGetCitiesInContinent_WithLimit() throws Exception {
        when(cityService.getAllCitiesInContinentLimited(anyString(), anyInt())).thenReturn(Collections.singletonList(mockCities.get(0)));

        mockMvc.perform(get("/cities/continent").param("continent", "Europe").param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("City1"));
    }

    @Test
    void testGetCitiesInCountry_NoLimit() throws Exception {
        when(cityService.getAllCitiesInCountry(anyString())).thenReturn(mockCities);

        mockMvc.perform(get("/cities/country").param("country", "Country1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("City1"));
    }

    @Test
    void testGetCitiesInDistrict_NoLimit() throws Exception {
        when(cityService.getAllCitiesInDistrict(anyString())).thenReturn(mockCities);

        mockMvc.perform(get("/cities/district").param("district", "District1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("City1"));
    }

    @Test
    void testGetCitiesInDistrict_WithLimit() throws Exception {
        when(cityService.getAllCitiesInDistrictLimited(anyString(), anyInt())).thenReturn(Collections.singletonList(mockCities.get(0)));

        mockMvc.perform(get("/cities/district").param("district", "District2").param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("City1"));
    }
}
