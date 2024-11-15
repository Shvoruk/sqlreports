package com.example.sqlreports.populationReport;

import org.springframework.data.relational.core.mapping.Column;

import java.math.BigInteger;

public class Country {

    @Column("Name")
    private String country;
    private BigInteger totalPopulation;
    private BigInteger cityPopulation;
    private BigInteger ruralPopulation;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigInteger getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(BigInteger totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public BigInteger getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(BigInteger cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public BigInteger getRuralPopulation() {
        return ruralPopulation;
    }

    public void setRuralPopulation(BigInteger ruralPopulation) {
        this.ruralPopulation = ruralPopulation;
    }
}
