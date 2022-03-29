package com.example.demo.dto;

import com.example.demo.entity.enumr.ProjectStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ProjectFilterDto {
    private String name;
    private ProjectStatus status;
    private Integer priority;
    private LocalDateTime startDateTo;
    private LocalDateTime startDateFrom;
    private LocalDateTime closeDateTo;
    private LocalDateTime closeDateFrom;
}
