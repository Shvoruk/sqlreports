package com.example.sqlreports.cityReport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CityEntityTest {

    @Test
    void testCityEntityGettersAndSetters() {
        CityEntity cityEntity = new CityEntity();

        String name = "Sample City";
        String country = "Sample Country";
        String district = "Sample District";
        Integer population = 500000;


        cityEntity.setName(name);
        cityEntity.setCountry(country);
        cityEntity.setDistrict(district);
        cityEntity.setPopulation(population);

        assertEquals(name, cityEntity.getName());
        assertEquals(country, cityEntity.getCountry());
        assertEquals(district, cityEntity.getDistrict());
        assertEquals(population, cityEntity.getPopulation());
    }
}