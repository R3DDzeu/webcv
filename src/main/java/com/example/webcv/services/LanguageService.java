package com.example.webcv.services;

import com.example.webcv.models.Entities.Language;
import com.example.webcv.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    // Create or Update a language
    public Language saveOrUpdateLanguage(Language language) {
        return languageRepository.save(language);
    }

    // Read all languages
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    // Read a single language by ID
    public Optional<Language> getLanguageById(Long id) {
        return languageRepository.findById(id);
    }

    // Delete a language by ID
    public void deleteLanguageById(Long id) {
        languageRepository.deleteById(id);
    }
}