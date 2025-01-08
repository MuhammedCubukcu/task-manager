package com.muhammedcbkc.task_management.service.impl;

import com.muhammedcbkc.task_management.dto.TaskDto;
import com.muhammedcbkc.task_management.entities.Task;
import com.muhammedcbkc.task_management.repository.TaskRepository;
import com.muhammedcbkc.task_management.service.ITaskService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskServiceImpl implements ITaskService {
    
    @Autowired
    private  TaskRepository taskRepository;

    @Override
    public TaskDto saveTask(TaskDto taskDto) {
        Task task = convertToEntity(taskDto);
        Task savedTask = taskRepository.save(task);
        return convertToDto(savedTask);
    }

    @Override
    public Optional<TaskDto> getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(this::convertToDto);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Task task = convertToEntity(taskDto);
        Task updatedTask = taskRepository.save(task);
        return convertToDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    private TaskDto convertToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setCompleted(task.getCompleted());
        taskDto.setDueDate(task.getDueDate());
        taskDto.setUserId(task.getUserId());
        taskDto.setCreatedAt(task.getCreatedAt());
        taskDto.setUpdatedAt(task.getUpdatedAt());
        return taskDto;
    }

    private Task convertToEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.getCompleted());
        task.setDueDate(taskDto.getDueDate());
        task.setUserId(taskDto.getUserId());
        task.setCreatedAt(taskDto.getCreatedAt());
        task.setUpdatedAt(taskDto.getUpdatedAt());
        return task;
    }

}