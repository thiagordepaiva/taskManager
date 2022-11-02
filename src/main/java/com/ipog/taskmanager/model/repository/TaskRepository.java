package com.ipog.taskmanager.model.repository;

import com.ipog.taskmanager.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByConcluded(Boolean concluded);
}
