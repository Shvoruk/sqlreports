package com.example.sqlreports.languageReport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LanguageController.class)
class LanguageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LanguageService languageService;

    private List<LanguageEntity> mockLanguages;

    @BeforeEach
    void setUp() {
        mockLanguages = Arrays.asList(
                createLanguageEntity("English", new BigDecimal("1300000000"), "17.0%"),
                createLanguageEntity("Mandarin", new BigDecimal("1100000000"), "15.0%")
        );
    }

    @Test
    void testGetLanguageReport() throws Exception {
        when(languageService.getLanguageSpeakersPercentage()).thenReturn(mockLanguages);

        mockMvc.perform(get("/language"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].language", is("English")))
                .andExpect(jsonPath("$[0].speakers", is(1300000000)))
                .andExpect(jsonPath("$[0].percentage", is("17.0%")))
                .andExpect(jsonPath("$[1].language", is("Mandarin")))
                .andExpect(jsonPath("$[1].speakers", is(1100000000)))
                .andExpect(jsonPath("$[1].percentage", is("15.0%")));

        verify(languageService, times(1)).getLanguageSpeakersPercentage();
        verifyNoMoreInteractions(languageService);
    }

    private LanguageEntity createLanguageEntity(String language, BigDecimal speakers, String percentage) {
        LanguageEntity entity = new LanguageEntity();
        entity.setLanguage(language);
        entity.setSpeakers(speakers);
        entity.setPercentage(percentage);
        return entity;
    }
}
