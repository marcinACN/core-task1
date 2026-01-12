package com.acn.task_mgr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @Size(max = 500)
    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    private LocalDateTime dueDate;

    @Size(max = 1000)
    private String notes;

    @Enumerated(EnumType.STRING)
    @NotNull
    private com.acn.task_mgr.model.TaskStatus status;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
        if (this.status == null) this.status = com.acn.task_mgr.model.TaskStatus.OPEN;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public com.acn.task_mgr.model.TaskStatus getStatus() { return status; }
    public void setStatus(com.acn.task_mgr.model.TaskStatus status) { this.status = status; }
}
