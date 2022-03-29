package com.example.demo.repository;

import com.example.demo.entity.Task;
import com.example.demo.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends BaseRepository<Task,Long> {

    @Query("select t from Task t where t.project.id=?1")
    List<Task> getTaskByProject(Long id);
}
