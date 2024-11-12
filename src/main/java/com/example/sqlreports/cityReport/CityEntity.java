package com.example.sqlreports.cityReport;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class CityEntity {

    @Id
    private Integer id;
    private String name;
    @Column("CountryCode")
    private String countryCode;
    private String district;
    private Integer population;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
