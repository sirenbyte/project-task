package com.example.demo.entity;

import com.example.demo.entity.enumr.StatusEnum;
import com.example.demo.entity.id.EntityId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Table(name = "task")
@Entity
public class Task implements EntityId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(sequenceName = "task_seq", allocationSize = 1, name = "task_seq")
    @JsonIgnore
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private Integer priority;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id", updatable = false, insertable = false)
    private Project project;

    @Column(name = "project_id")
    private Long projectId;

}
/*
  "closeDateFrom": "2022-03-29T14:35:49.193Z",
          "closeDateTo": "2022-03-29T14:35:49.193Z",
          "name": "string",
          "priority": 0,
          "startDateFrom": "2022-03-29T14:35:49.193Z",
          "startDateTo": "2022-03-29T14:35:49.193Z",
          "status": "Active"
*/
