package com.example.upb_projects.services;

import com.example.upb_projects.controller.request.ProjectsRequest;
import com.example.upb_projects.controller.response.ProjectsReponse;
import com.example.upb_projects.model.entity.Projects;
import com.example.upb_projects.model.repository.ProjectsRepository;
import com.example.upb_projects.services.service.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsService {
    private final ProjectsRepository projectsRepository;

    @Override
    public List<Projects> getProjectsList() {
        return projectsRepository.projectsList();
    }

    @Override
    public void deleteProjectById(Long projectId) {
        projectsRepository.deleteById(projectId);
    }

    @Override
    public ProjectsReponse searchProject(Long projectId) {
        Projects projects = projectsRepository.searchProject(projectId);

        return Objects.nonNull(projects)
                ? buildProjectsReponse(projects)
                : ProjectsReponse.builder().build();
    }

    @Override
    public void saveProject(ProjectsRequest projectsRequest) {
        if (Objects.nonNull(projectsRequest)) {
            Projects projects = buildProjectsEntity(projectsRequest);
            projectsRepository.save(projects);
        }
    }

    @Override
    public void updateProject(ProjectsRequest projectsRequest) {
        if(Objects.nonNull(projectsRequest)) {
            Optional<Projects> projects = projectsRepository.findById(projectsRequest.getProjectId());

            if (projects.isPresent()) {
                Projects updateProjects = buildProjectsEntity(projectsRequest);
                projectsRepository.save(updateProjects);
            }
        }
    }

    private static ProjectsReponse buildProjectsReponse(Projects projects) {
        return ProjectsReponse.builder()
                .projectId(projects.getProjectId())
                .projectName(projects.getProjectName())
                .projectStartDate(projects.getProjectStartDate())
                .projectEndDate(projects.getProjectEndDate())
                .build();
    }

    private static Projects buildProjectsEntity(ProjectsRequest projectsRequest) {
        return Projects.builder()
                .projectId(projectsRequest.getProjectId())
                .projectName(projectsRequest.getProjectName())
                .projectStartDate(projectsRequest.getProjectStartDate())
                .projectEndDate(projectsRequest.getProjectEndDate())
                .build();
    }
}
