package com.example.upb_projects.services.service;

import com.example.upb_projects.controller.request.ProjectsRequest;
import com.example.upb_projects.controller.response.ProjectsReponse;
import com.example.upb_projects.model.entity.Projects;

import java.util.List;

public interface ProjectsService {
    List<Projects> getProjectsList();
    void deleteProjectById(Long projectId);
    ProjectsReponse searchProject(Long projectId);
    void saveProject(ProjectsRequest projectsRequest);
    void updateProject(ProjectsRequest projectsRequest);
}
