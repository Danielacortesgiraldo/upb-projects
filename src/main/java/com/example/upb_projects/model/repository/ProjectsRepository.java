package com.example.upb_projects.model.repository;

import com.example.upb_projects.model.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {
    @Query(value = "SELECT * FROM projects", nativeQuery = true)
    List<Projects> projectsList();

    @Query(value = "SELECT * FROM projects WHERE id = :projectId", nativeQuery = true)
    Projects searchProject(@Param("projectId") Long projectId);
}
