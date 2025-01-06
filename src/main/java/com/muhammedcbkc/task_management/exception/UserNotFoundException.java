package com.muhammedcbkc.task_management.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException {
    private String errorCode;

    public UserNotFoundException(String message) {
        super(message);
    }           
        
}
