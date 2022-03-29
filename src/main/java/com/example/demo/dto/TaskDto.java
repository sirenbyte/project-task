package com.example.demo.dto;

import com.example.demo.entity.enumr.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private String name;
    private String description;
    private Integer priority;
    private StatusEnum status;
    private Long projectId;

}
