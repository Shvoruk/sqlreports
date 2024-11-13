package com.example.sqlreports.countryReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    private List<CountryEntity> mockCountries;

    @BeforeEach
    void setUp() {
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
    void testGetCountriesInTheWorld_NoLimit() throws Exception {
        when(countryService.getAllCountriesInWorld()).thenReturn(mockCountries);

        mockMvc.perform(get("/countries/world"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].code").value("C1"))
                .andExpect(jsonPath("$[0].name").value("Country1"))
                .andExpect(jsonPath("$[0].continent").value("Continent1"))
                .andExpect(jsonPath("$[0].region").value("Region1"))
                .andExpect(jsonPath("$[0].population").value(5000000))
                .andExpect(jsonPath("$[0].capital").value(1))
                .andExpect(jsonPath("$[1].name").value("Country2"));
    }

    @Test
    void testGetCountriesInTheWorld_WithLimit() throws Exception {
        when(countryService.getAllCountriesInWorldLimited(anyInt())).thenReturn(Collections.singletonList(mockCountries.get(0)));

        mockMvc.perform(get("/countries/world").param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Country1"));
    }

    @Test
    void testGetCountriesInTheContinent_NoLimit() throws Exception {
        when(countryService.getAllCountriesInContinent(anyString())).thenReturn(mockCountries);

        mockMvc.perform(get("/countries/continent").param("continent", "Continent1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Country1"));
    }

    @Test
    void testGetCountriesInTheContinent_WithLimit() throws Exception {
        when(countryService.getAllCountriesInContinentLimited(anyString(), anyInt())).thenReturn(Collections.singletonList(mockCountries.get(0)));

        mockMvc.perform(get("/countries/continent")
                        .param("continent", "Continent1")
                        .param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Country1"));
    }

    @Test
    void testGetCountriesInTheRegion_NoLimit() throws Exception {
        when(countryService.getAllCountriesInRegion(anyString())).thenReturn(mockCountries);

        mockMvc.perform(get("/countries/region").param("region", "Region1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Country1"));
    }

    @Test
    void testGetCountriesInTheRegion_WithLimit() throws Exception {
        when(countryService.getAllCountriesInRegionLimited(anyString(), anyInt())).thenReturn(Collections.singletonList(mockCountries.get(0)));

        mockMvc.perform(get("/countries/region")
                        .param("region", "Region1")
                        .param("limit", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Country1"));
    }
}
