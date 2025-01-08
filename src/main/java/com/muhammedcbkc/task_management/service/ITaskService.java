package com.muhammedcbkc.task_management.service;

import com.muhammedcbkc.task_management.dto.TaskDto;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    public TaskDto saveTask(TaskDto taskDto);
    
    public Optional<TaskDto> getTaskById(Long id);
    public List<TaskDto> getAllTasks();
    public TaskDto updateTask(TaskDto taskDto);
    public void deleteTask(Long id);
}