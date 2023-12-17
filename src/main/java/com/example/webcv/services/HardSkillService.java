package com.example.webcv.services;

import com.example.webcv.models.Entities.HardSkill;
import com.example.webcv.repositories.HardSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HardSkillService {

    private final HardSkillRepository hardSkillRepository;

    @Autowired
    public HardSkillService(HardSkillRepository hardSkillRepository) {
        this.hardSkillRepository = hardSkillRepository;
    }

    // Create or Update a hard skill
    public HardSkill saveOrUpdateHardSkill(HardSkill hardSkill) {
        return hardSkillRepository.save(hardSkill);
    }

    // Read all hard skills
    public List<HardSkill> getAllHardSkills() {
        return hardSkillRepository.findAll();
    }

    // Read a single hard skill by ID
    public Optional<HardSkill> getHardSkillById(Long id) {
        return hardSkillRepository.findById(id);
    }

    // Delete a hard skill by ID
    public void deleteHardSkillById(Long id) {
        hardSkillRepository.deleteById(id);
    }
}