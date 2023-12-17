package com.example.webcv.services;
import com.example.webcv.models.Entities.Experience;
import com.example.webcv.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    // Create or Update an experience record
    public Experience saveOrUpdateExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    // Read all experience records
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    // Read a single experience record by ID
    public Optional<Experience> getExperienceById(Long id) {
        return experienceRepository.findById(id);
    }

    // Delete an experience record by ID
    public void deleteExperienceById(Long id) {
        experienceRepository.deleteById(id);
    }
}