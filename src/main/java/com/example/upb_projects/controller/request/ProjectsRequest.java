package com.example.upb_projects.controller.request;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectsRequest {
    private Long projectId;
    private String projectName;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
}
