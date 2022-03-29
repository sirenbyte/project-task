package com.example.demo.service.impl;

import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.api.ProjectService;
import com.example.demo.service.base.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectServiceImpl extends BaseServiceImpl<Project, Long, ProjectRepository> implements ProjectService {

    @Override
    public Project createProject(ProjectDto dto) {
        Project project = new Project();
        project.setCloseDate(dto.getCloseDate());
        project.setStartDate(dto.getStartDate());
        return save(mapDtoToProject(project,dto));
    }

    @Override
    public Project editProject(Long id,ProjectDto dto) {
        Project project = findOrThrow(id);
        return edit(mapDtoToProject(project,dto));
    }

    private Project mapDtoToProject(Project project,ProjectDto dto){
        project.setPriority(dto.getPriority());
        project.setName(dto.getName());
        project.setStatus(dto.getStatus());
        return project;
    }
}
