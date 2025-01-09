package com.muhammedcbkc.task_management.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}