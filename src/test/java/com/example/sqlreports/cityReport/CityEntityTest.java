package com.example.sqlreports.cityReport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CityEntityTest {

    @Test
    void testCityEntityGettersAndSetters() {
        CityEntity cityEntity = new CityEntity();

        Integer id = 1;
        String name = "Sample City";
        String countryCode = "SC";
        String district = "Sample District";
        Integer population = 500000;

        cityEntity.setId(id);
        cityEntity.setName(name);
        cityEntity.setCountryCode(countryCode);
        cityEntity.setDistrict(district);
        cityEntity.setPopulation(population);

        assertEquals(id, cityEntity.getId());
        assertEquals(name, cityEntity.getName());
        assertEquals(countryCode, cityEntity.getCountryCode());
        assertEquals(district, cityEntity.getDistrict());
        assertEquals(population, cityEntity.getPopulation());
    }
}
