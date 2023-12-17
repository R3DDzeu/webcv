package com.example.webcv.controllers;

import com.example.webcv.models.DTOs.EducationDTO;
import com.example.webcv.models.Entities.Education;
import com.example.webcv.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    public ResponseEntity<Education> createEducation(@RequestBody EducationDTO educationDTO) {
        Education education = convertToEntity(educationDTO);
        Education savedEducation = educationService.saveOrUpdateEducation(
                education,
                educationDTO.getHardSkillsIds(),
                educationDTO.getLanguagesIds()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEducation);
    }

    @GetMapping
    public List<Education> getAllEducation() {
        return educationService.getAllEducation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long id) {
        return educationService.getEducationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education education) {
        return ResponseEntity.ok(educationService.saveOrUpdateEducation(education));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        educationService.deleteEducationById(id);
        return ResponseEntity.ok().build();
    }
    private Education convertToEntity(EducationDTO educationDTO) {
        Education education = new Education();
        education.setName(educationDTO.getName());
        education.setPeriod(educationDTO.getPeriod());
        // Map other fields if necessary
        return education;
    }
}
