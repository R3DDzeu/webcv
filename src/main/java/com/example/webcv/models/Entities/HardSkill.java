package com.example.webcv.models.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "hardskills")
@Getter
@Setter
    public class HardSkill {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String name;

    @Column(nullable = false, unique = true)
    private String level;

    @ManyToMany(mappedBy = "hardSkills")
    private Set<Education> educations;



    }

