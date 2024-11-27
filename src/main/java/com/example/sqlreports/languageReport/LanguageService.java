package com.example.sqlreports.languageReport;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<LanguageEntity> getLanguageSpeakersPercentage(){
        return languageRepository.findLanguageSpeakersPercentage();
    }
}
