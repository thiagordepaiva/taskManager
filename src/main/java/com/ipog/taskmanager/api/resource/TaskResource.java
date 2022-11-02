package com.ipog.taskmanager.api.resource;

import com.ipog.taskmanager.DTO.TaskDTO;
import com.ipog.taskmanager.exception.BusinessRuleException;
import com.ipog.taskmanager.model.entity.Task;
import com.ipog.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
public class TaskResource {

    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody TaskDTO taskDTO) {
        try {
            Task task = new Task();
            task.setDescription(taskDTO.getDescription());
            task.setPriority(taskDTO.getPriority());

            Task taskSaved = taskService.save(task);

            return new ResponseEntity(taskSaved, HttpStatus.CREATED);
        } catch (BusinessRuleException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<Task> task = taskService.getById(id);

        if (!task.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
            taskService.delete(task.get());

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity patch(@RequestBody TaskDTO taskDTO) {
        try {
            Task task;
            Optional<Task> optionalTask = taskService.getById(taskDTO.getId());

            if (!optionalTask.isPresent())
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                task = optionalTask.get();

            task.setDescription(taskDTO.getDescription());
            task.setPriority(taskDTO.getPriority());

            Task taskSaved = taskService.save(task);

            return new ResponseEntity(taskSaved, HttpStatus.ACCEPTED);
        } catch (BusinessRuleException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("concluida")
    public ResponseEntity patchConcluded(@RequestBody TaskDTO taskDTO) {
        try {
            Task task;
            Optional<Task> optionalTask = taskService.getById(taskDTO.getId());

            if (!optionalTask.isPresent())
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                task = optionalTask.get();

            task.setConcluded(Boolean.TRUE);

            Task taskSaved = taskService.save(task);

            return new ResponseEntity(taskSaved, HttpStatus.ACCEPTED);
        } catch (BusinessRuleException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("nao-concluidas")
    public ResponseEntity getNotConcludeds() {
        return ResponseEntity.ok(taskService.getNotConcludeds());
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Optional<Task> task = taskService.getById(id);

        if (!task.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(task);
    }
}
