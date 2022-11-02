package com.ipog.taskmanager.DTO;

public class TaskDTO {

    private Long id;
    private String description;
    private String priority;
    private Boolean concluded;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String description, String priority, Boolean concluded) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.concluded = concluded;
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
}
