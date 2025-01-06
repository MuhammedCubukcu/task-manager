package com.muhammedcbkc.task_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muhammedcbkc.task_management.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}