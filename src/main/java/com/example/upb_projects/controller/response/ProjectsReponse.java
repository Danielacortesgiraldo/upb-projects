package com.example.upb_projects.controller.response;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectsReponse {
    private Long projectId;
    private String projectName;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
}
