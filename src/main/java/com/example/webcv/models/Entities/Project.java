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
@Table(name = "projects")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100)
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "project_hard_skill",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "hard_skill_id")
    )
    private Set<HardSkill> technologies;

    @Size(max = 255)
    private String context;

    @Size(max = 1000)
    private String description;
}
