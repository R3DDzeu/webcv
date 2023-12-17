package com.example.webcv.repositories;

import com.example.webcv.models.Entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
