package com.ipog.taskmanager.service;

import com.ipog.taskmanager.model.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task save(Task task);

    void delete(Task task);

    Optional<Task> getById(Long id);

    List<Task> getAll();

    List<Task> getNotConcludeds();
}
