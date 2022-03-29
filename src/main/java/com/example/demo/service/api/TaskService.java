package com.example.demo.service.api;

import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Task;
import com.example.demo.service.base.BaseService;

import java.util.List;

public interface TaskService extends BaseService<Task, Long> {
    Task addTaskToProject(TaskDto dto);
    Task update(Long id,TaskDto dto);
    List<Task> getTasksByProject(Long id);
}
