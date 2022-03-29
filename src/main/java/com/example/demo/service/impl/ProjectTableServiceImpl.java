package com.example.demo.service.impl;

import com.example.demo.dto.ProjectFilterDto;
import com.example.demo.entity.Project;
import com.example.demo.entity.QProject;
import com.example.demo.service.api.ProjectService;
import com.example.demo.service.api.ProjectTableService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectTableServiceImpl implements ProjectTableService {
    private final ProjectService projectService;
    private final EntityManager entityManager;

    public List<Project> filter(ProjectFilterDto dto) {
        JPAQuery<Project> jpaQuery = new JPAQuery<>(entityManager);
        QProject qProject = QProject.project;
        BooleanBuilder where = filterWithClause(qProject,dto);

        jpaQuery.select(Projections.fields(
                        Project.class,
                        qProject.name,
                        qProject.closeDate,
                        qProject.priority,
                        qProject.status,
                        qProject.startDate
                )).from(qProject)
                .where(where)
                .orderBy(new OrderSpecifier<>(Order.ASC, new PathBuilder(Object.class, "project.id")));

        return jpaQuery.fetch();
    }

    private BooleanBuilder filterWithClause(QProject qProject,ProjectFilterDto dto) {
        BooleanBuilder where = new BooleanBuilder();

        Optional.ofNullable(dto.getName())
                .filter(StringUtils::hasText)
                .ifPresent(it -> where.and(qProject.name.containsIgnoreCase(it)));
        Optional.ofNullable(dto.getStatus())
                .filter(it-> String.valueOf(it).equals(""))
                .ifPresent(it -> where.and(qProject.status.eq(it)));
        Optional.ofNullable(dto.getPriority())
                .ifPresent(it -> where.and(qProject.priority.eq(it)));
        Optional.ofNullable(dto.getStartDateTo())
                .ifPresent(it -> where.and(qProject.startDate.before(it)));
        Optional.ofNullable(dto.getCloseDateTo())
                .ifPresent(it -> where.and(qProject.closeDate.before(it)));
        Optional.ofNullable(dto.getCloseDateFrom())
                .ifPresent(it -> where.and(qProject.closeDate.after(it)));
        Optional.ofNullable(dto.getStartDateFrom())
                .ifPresent(it -> where.and(qProject.startDate.after(it)));

        return where;
    }
}
