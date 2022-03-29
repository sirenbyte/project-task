package com.example.demo.repository;

import com.example.demo.entity.Project;
import com.example.demo.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends BaseRepository<Project,Long> {
}
