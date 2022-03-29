package com.example.demo.controller;

import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Task;
import com.example.demo.service.api.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Task controller")
@RestController
@RequestMapping("/api/v1/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @ApiOperation(value = "Create task",notes = "Create task")
    @PostMapping("/create")
    public ResponseEntity<Void> createTask(@RequestBody TaskDto dto) {
        taskService.addTaskToProject(dto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Get task",notes = "Get task")
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.findOrThrow(id));
    }

    @ApiOperation(value = "Update task",notes = "Update task")
    @PutMapping("/{id}")
    public ResponseEntity<Task> editTask(@RequestBody TaskDto dto, @PathVariable Long id) {
        return ResponseEntity.ok(taskService.update(id, dto));
    }

    @ApiOperation(value = "All task from project",notes = "All task from project")
    @GetMapping("/project/{id}")
    public ResponseEntity<List<Task>> getTasks(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTasksByProject(id));
    }

    @ApiOperation(value = "Delete task",notes = "Delete task")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }
}
