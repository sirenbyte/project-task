package com.example.demo.dto;

import com.example.demo.entity.enumr.ProjectStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProjectDto {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime closeDate;
    private ProjectStatus status;
    private Integer priority;
}
