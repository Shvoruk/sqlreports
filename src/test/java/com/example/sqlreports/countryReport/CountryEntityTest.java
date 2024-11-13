package com.example.sqlreports.countryReport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryEntityTest {

    @Test
    void testCountryEntityGettersAndSetters() {
        CountryEntity country = new CountryEntity();

        String code = "C1";
        String name = "Country1";
        String continent = "Continent1";
        String region = "Region1";
        Integer population = 5000000;
        Integer capital = 100;

        country.setCode(code);
        country.setName(name);
        country.setContinent(continent);
        country.setRegion(region);
        country.setPopulation(population);
        country.setCapital(capital);

        assertEquals(code, country.getCode());
        assertEquals(name, country.getName());
        assertEquals(continent, country.getContinent());
        assertEquals(region, country.getRegion());
        assertEquals(population, country.getPopulation());
        assertEquals(capital, country.getCapital());
    }
}
