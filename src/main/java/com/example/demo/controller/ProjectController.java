package com.example.demo.controller;

import com.example.demo.dto.ProjectDto;
import com.example.demo.dto.ProjectFilterDto;
import com.example.demo.entity.Project;
import com.example.demo.service.api.ProjectService;
import com.example.demo.service.api.ProjectTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Project controller")
@RestController
@RequestMapping("/api/v1/project")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectTableService projectTableService;

    @ApiOperation(value = "Get project",notes = "Get project")
    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(@PathVariable Long id){
        return ResponseEntity.ok(projectService.findOrThrow(id));
    }

    @ApiOperation(value = "Delete project",notes = "Delete project")
    @DeleteMapping("/{id}")
    public ResponseEntity<Project> deleteById(@PathVariable Long id){
        projectService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Create project",notes = "Create project")
    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody ProjectDto dto){
        return ResponseEntity.ok(projectService.createProject(dto));
    }

    @ApiOperation(value = "Update project",notes = "Update project")
    @PutMapping("/{id}")
    public ResponseEntity<Project> editProject(@PathVariable Long id,@RequestBody ProjectDto dto){
        return ResponseEntity.ok(projectService.editProject(id,dto));
    }

    @ApiOperation(value = "List project",notes = "List project")
    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAll(){
        return ResponseEntity.ok(projectService.getAll());
    }

    @ApiOperation(value = "Filtered projects",notes = "Filtered projects")
    @PostMapping("/filter")
    public ResponseEntity<List<Project>> getWithFIlter(@RequestBody ProjectFilterDto dto){
        return ResponseEntity.ok(projectTableService.filter(dto));
    }
}
