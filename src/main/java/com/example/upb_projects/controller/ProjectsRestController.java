package com.example.upb_projects.controller;

import com.example.upb_projects.controller.request.ProjectsRequest;
import com.example.upb_projects.controller.response.ProjectsReponse;
import com.example.upb_projects.model.entity.Projects;
import com.example.upb_projects.services.service.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects/v1")
@RequiredArgsConstructor
public class ProjectsRestController {
    private final ProjectsService projectsService;
    String message = "Operation completed successfully.";

    @GetMapping("/list")
    public ResponseEntity<List<Projects>> listProjectsApi() {
        List<Projects> projectsList = projectsService.getProjectsList();
        return new ResponseEntity<>(projectsList,HttpStatus.ACCEPTED );
    }

    @GetMapping("/search/{projectId}")
    public ResponseEntity<ProjectsReponse> searchProjectApi(@PathVariable Long projectId) {
        ProjectsReponse projectsReponse = projectsService.searchProject(projectId);
        return ResponseEntity.accepted().body(projectsReponse);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProjectById(@RequestParam(name = "projectId") Long projectId) {
        projectsService.deleteProjectById(projectId);
        return ResponseEntity.accepted().body(message);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveProjectApi(@RequestBody ProjectsRequest projectsRequest) {
        projectsService.saveProject(projectsRequest);
        return ResponseEntity.accepted().body(message);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateProjectApi(@RequestBody ProjectsRequest projectsRequest) {
        projectsService.updateProject(projectsRequest);
        return ResponseEntity.accepted().body(message);
    }
}
