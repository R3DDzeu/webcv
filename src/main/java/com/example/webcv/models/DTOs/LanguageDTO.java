package com.example.webcv.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {

    private Long id;
    private String name;
    private String level;
    private Set<EducationDTO> educations;
}