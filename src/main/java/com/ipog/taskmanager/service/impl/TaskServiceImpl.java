package com.ipog.taskmanager.service.impl;

import com.ipog.taskmanager.exception.BusinessRuleException;
import com.ipog.taskmanager.model.entity.Task;
import com.ipog.taskmanager.model.enums.PrioritysEnum;
import com.ipog.taskmanager.model.repository.TaskRepository;
import com.ipog.taskmanager.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository repository) {
        super();
        this.taskRepository = repository;
    }

    @Override
    @Transactional
    public Task save(Task task) {
        validateTask(task);

        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public void delete(Task task) {
        taskRepository.delete(task);
    }

    public void validateTask(Task task) {
        if (task.getDescription() == null || task.getDescription().length() > 500) {
            throw new BusinessRuleException("A descrição da tarefa não pode ter mais que 500 caracteres.");
        }

        if (task.getPriority() != null) {
            PrioritysEnum priority = PrioritysEnum.get(task.getPriority());
            if (priority == null)
                throw new BusinessRuleException("Prioridade invalida. Opções(Alta, Média, Baixa).");
        } else {
            throw new BusinessRuleException("Prioridade invalida. Opções(Alta, Média, Baixa).");
        }
    }

    @Override
    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getNotConcludeds() {
        return taskRepository.findByConcluded(Boolean.FALSE);
    }
}
