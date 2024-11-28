package com.example.sqlreports.languageReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "/test-data.sql")
class LanguageRepositoryTest {

    @Autowired
    private LanguageRepository languageRepository;

    @BeforeEach
    void setUp() {
        // Test data is loaded via @Sql annotation
    }

    @Test
    void testFindLanguageSpeakersPercentage() {
        List<LanguageEntity> result = languageRepository.findLanguageSpeakersPercentage();

        assertNotNull(result);
        assertEquals(3, result.size()); // Assuming 3 languages in test data

        LanguageEntity firstLanguage = result.get(0);
        assertEquals("Chinese", firstLanguage.getLanguage());
        assertTrue(firstLanguage.getSpeakers().compareTo(new BigDecimal("1500000000")) > 0); // Example validation
        assertEquals("18.75%", firstLanguage.getPercentage()); // Adjust to match your test data

        LanguageEntity secondLanguage = result.get(1);
        assertEquals("English", secondLanguage.getLanguage());
    }
}
