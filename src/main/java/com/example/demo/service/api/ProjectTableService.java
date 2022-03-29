package com.example.demo.service.api;

import com.example.demo.dto.ProjectFilterDto;
import com.example.demo.entity.Project;

import java.util.List;

public interface ProjectTableService {
    List<Project> filter(ProjectFilterDto dto);
}
