package org.example.project.service;

import lombok.RequiredArgsConstructor;
import org.example.project.dto.ProjectRequest;
import org.example.project.dto.ProjectResponse;
import org.example.project.entity.Project;
import org.example.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectResponse createProject(ProjectRequest request) {
        Project project = Project.builder()
                .name(request.name())
                .description(request.description())
                .build();

        return ProjectResponse.from(projectRepository.save(project));
    }

    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectResponse::from)
                .toList();
    }

    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found: " + projectId));
    }
}