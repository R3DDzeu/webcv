package com.example.webcv.services;

import com.example.webcv.models.Entities.Education;
import com.example.webcv.models.Entities.HardSkill;
import com.example.webcv.models.Entities.Language;
import com.example.webcv.repositories.EducationRepository;
import com.example.webcv.repositories.HardSkillRepository;
import com.example.webcv.repositories.LanguageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private HardSkillRepository hardSkillRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }
    @Transactional
    public Education saveOrUpdateEducation(Education education, Set<Long> hardSkillIds, Set<Long> languageIds) {
        if (hardSkillIds != null && !hardSkillIds.isEmpty()) {
            Set<HardSkill> hardSkills = new HashSet<>(hardSkillRepository.findAllById(hardSkillIds));
            education.setHardSkills(hardSkills);
        }

        if (languageIds != null && !languageIds.isEmpty()) {
            Set<Language> languages = new HashSet<>(languageRepository.findAllById(languageIds));
            education.setLanguages(languages);
        }

        return educationRepository.save(education);
    }




    // Create or Update an education record
    public Education saveOrUpdateEducation(Education education) {
        return educationRepository.save(education);
    }

    // Read all education records
    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    // Read a single education record by ID
    public Optional<Education> getEducationById(Long id) {
        return educationRepository.findById(id);
    }

    // Delete an education record by ID
    public void deleteEducationById(Long id) {
        educationRepository.deleteById(id);
    }
}