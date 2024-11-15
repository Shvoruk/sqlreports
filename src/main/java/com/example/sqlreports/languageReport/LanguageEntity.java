package com.example.sqlreports.languageReport;

import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

public class LanguageEntity {

    String language;
    BigDecimal speakers;
    String percentage;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public BigDecimal getSpeakers() {
        return speakers;
    }

    public void setSpeakers(BigDecimal speakers) {
        this.speakers = speakers;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
