package com.example.sqlreports.languageReport;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LanguageEntityTest {

    @Test
    void testLanguageEntitySettersAndGetters() {
        LanguageEntity languageEntity = new LanguageEntity();

        // Test the language property
        languageEntity.setLanguage("English");
        assertEquals("English", languageEntity.getLanguage());

        // Test the speakers property
        BigDecimal speakers = new BigDecimal("1300000000");
        languageEntity.setSpeakers(speakers);
        assertEquals(speakers, languageEntity.getSpeakers());

        // Test the percentage property
        languageEntity.setPercentage("17.0%");
        assertEquals("17.0%", languageEntity.getPercentage());
    }

    @Test
    void testLanguageEntityDefaultValues() {
        LanguageEntity languageEntity = new LanguageEntity();

        // Test default values (should be null)
        assertNull(languageEntity.getLanguage());
        assertNull(languageEntity.getSpeakers());
        assertNull(languageEntity.getPercentage());
    }
}
