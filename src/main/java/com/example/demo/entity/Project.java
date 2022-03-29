package com.example.demo.entity;

import com.example.demo.entity.enumr.ProjectStatus;
import com.example.demo.entity.id.EntityId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Table(name = "project")
@Entity
public class Project implements EntityId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(sequenceName = "project_seq", allocationSize = 1, name = "project_seq")
    @JsonIgnore
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "close_date")
    private LocalDateTime closeDate;

    @Column(name = "status")
    private ProjectStatus status;

    @Column(name = "priority")
    private Integer priority;
}
