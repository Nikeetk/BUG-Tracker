package org.example.project.dto;

import org.example.project.entity.Project;

public record ProjectResponse(
        Long id,
        String name,
        String description
) {
    public static ProjectResponse from(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription()
        );
    }
}