package com.example.sqlreports.populationReport;

import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

public class Continent {

    private String continent;
    private BigDecimal totalPopulation;
    private BigDecimal cityPopulation;
    private String cityPercentage;
    private BigDecimal ruralPopulation;
    private String ruralPercentage;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public BigDecimal getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(BigDecimal totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public BigDecimal getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(BigDecimal cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public BigDecimal getRuralPopulation() {
        return ruralPopulation;
    }

    public void setRuralPopulation(BigDecimal ruralPopulation) {
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
