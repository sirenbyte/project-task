package com.example.demo.service.api;

import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Project;
import com.example.demo.service.base.BaseService;

public interface ProjectService extends BaseService<Project, Long> {
    Project createProject(ProjectDto dto);

    Project editProject(Long id,ProjectDto dto);
}
