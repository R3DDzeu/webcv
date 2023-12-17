package com.example.webcv.models.DTOs;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDTO {

    private Long id;
    private String name;
    private String period;
    private Set<HardSkillDTO> hardSkills;
    private Set<LanguageDTO> languages;
    private String company;
    private String type;
    private Set<Long> hardSkillsIds;
    private Set<Long> languagesIds;

}