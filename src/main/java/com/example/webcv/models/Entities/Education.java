package com.example.webcv.models.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "education")
@Getter
@Setter
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100)
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Period is mandatory")
    @Size(max = 50)
    @Column(nullable = false)
    private String period;

    @ManyToMany
    @JoinTable(
            name = "education_hard_skill",
            joinColumns = @JoinColumn(name = "education_id"),
            inverseJoinColumns = @JoinColumn(name = "hard_skill_id")
    )
    private Set<HardSkill> hardSkills;

    @ManyToMany
    @JoinTable(
            name = "education_language",
            joinColumns = @JoinColumn(name = "education_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages;


}