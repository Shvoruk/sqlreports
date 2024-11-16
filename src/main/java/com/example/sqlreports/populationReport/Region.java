package com.example.sqlreports.populationReport;

import org.springframework.data.relational.core.mapping.Column;

import java.math.BigInteger;

public class Region {

    private String region;
    private BigInteger totalPopulation;
    private BigInteger cityPopulation;
    private String cityPercentage;
    private BigInteger ruralPopulation;
    private String ruralPercentage;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public String getCityPercentage() {
        return cityPercentage;
    }

    public void setCityPercentage(String cityPercentage) {
        this.cityPercentage = cityPercentage;
    }

    public String getRuralPercentage() {
        return ruralPercentage;
    }

    public void setRuralPercentage(String ruralPercentage) {
        this.ruralPercentage = ruralPercentage;
    }
}
