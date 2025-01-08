package com.muhammedcbkc.task_management.repository;

import com.muhammedcbkc.task_management.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}