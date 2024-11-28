package com.example.sqlreports.languageReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LanguageServiceTest {

    private LanguageService languageService;

    @Mock
    private LanguageRepository languageRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        languageService = new LanguageService(languageRepository);
    }

    @Test
    void testGetLanguageSpeakersPercentage() {
        List<LanguageEntity> mockLanguages = Arrays.asList(
                new LanguageEntity() {{
                    setLanguage("English");
                    setSpeakers(new BigDecimal("1300000000"));
                    setPercentage("17.0%");
                }},
                new LanguageEntity() {{
                    setLanguage("Mandarin");
                    setSpeakers(new BigDecimal("1100000000"));
                    setPercentage("15.0%");
                }}
        );

        when(languageRepository.findLanguageSpeakersPercentage()).thenReturn(mockLanguages);

        List<LanguageEntity> result = languageService.getLanguageSpeakersPercentage();

        assertEquals(2, result.size());
        assertEquals("English", result.get(0).getLanguage());
        assertEquals(new BigDecimal("1300000000"), result.get(0).getSpeakers());
        assertEquals("17.0%", result.get(0).getPercentage());
        assertEquals("Mandarin", result.get(1).getLanguage());
        assertEquals(new BigDecimal("1100000000"), result.get(1).getSpeakers());
        assertEquals("15.0%", result.get(1).getPercentage());

        verify(languageRepository, times(1)).findLanguageSpeakersPercentage();
        verifyNoMoreInteractions(languageRepository);
    }
}
