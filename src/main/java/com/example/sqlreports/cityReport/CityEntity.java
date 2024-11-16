package com.example.sqlreports.cityReport;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class CityEntity {

    private String name;
    @Column("CountryCode")
    private String countryCode;
    private String district;
    private Integer population;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
