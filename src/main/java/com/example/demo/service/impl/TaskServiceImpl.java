package com.example.demo.service.impl;

import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Project;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.api.ProjectService;
import com.example.demo.service.api.TaskService;
import com.example.demo.service.base.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl extends BaseServiceImpl<Task, Long, TaskRepository> implements TaskService {

    private final ProjectService projectService;

    @Override
    public Task addTaskToProject(TaskDto dto) {
        Task task = new Task();
        task.setProjectId(dto.getProjectId());
        return save(mapDtoToTask(task,dto));
    }

    @Override
    public Task update(Long id, TaskDto dto) {
        Task task = findOrThrow(id);
        return edit(mapDtoToTask(task, dto));
    }

    private Task mapDtoToTask(Task task, TaskDto dto) {
        task.setDescription(dto.getDescription());
        task.setName(dto.getName());
        task.setPriority(dto.getPriority());
        task.setStatus(dto.getStatus());
        return task;
    }

    @Override
    public List<Task> getTasksByProject(Long id) {
        return getRepository().getTaskByProject(id);
    }

    private Project findProjectById(Long id) {
        return projectService.findOrThrow(id);
    }
}
