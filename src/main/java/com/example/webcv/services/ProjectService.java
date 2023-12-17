package com.example.webcv.services;

import com.example.webcv.models.Entities.Project;
import com.example.webcv.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Create or Update a project
    public Project saveOrUpdateProject(Project project) {
        return projectRepository.save(project);
    }

    // Read all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Read a single project by ID
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    // Delete a project by ID
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }
}