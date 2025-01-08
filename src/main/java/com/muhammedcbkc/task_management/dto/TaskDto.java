package com.muhammedcbkc.task_management.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TaskDto {
    private Long id;

    private String title;
    
    private String description;
    
    private Boolean completed;
    
    private LocalDate dueDate;
    
    private Long userId;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

}