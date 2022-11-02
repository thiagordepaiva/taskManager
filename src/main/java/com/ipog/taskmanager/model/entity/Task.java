package com.ipog.taskmanager.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tarefas", schema = "public")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String description;

    @Column(name = "prioridade")
    private String priority;

    @Column(name = "concluido")
    private Boolean concluded = Boolean.FALSE;

    public Task(Long id, String description, String priority, Boolean concluded) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.concluded = concluded;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Boolean getConcluded() {
        return concluded;
    }

    public void setConcluded(Boolean concluded) {
        this.concluded = concluded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id)
                && Objects.equals(description, task.description)
                && Objects.equals(priority, task.priority)
                && Objects.equals(concluded, task.concluded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, priority, concluded);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", concluded=" + concluded.toString() +
                '}';
    }
}
