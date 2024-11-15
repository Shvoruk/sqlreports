package com.example.sqlreports.populationReport;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

public class PopulationEntity {

    @Column("name")
    private String name;

    @Column("population")
    private BigDecimal totalPopulation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPopulation() {
        return totalPopulation;
    }

    public void setPopulation(BigDecimal totalPopulation) {
        this.totalPopulation = totalPopulation;
    }
}
