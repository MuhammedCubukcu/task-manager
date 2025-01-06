package com.muhammedcbkc.task_management.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammedcbkc.task_management.controller.IUserController;
import com.muhammedcbkc.task_management.dto.DtoUser;
import com.muhammedcbkc.task_management.dto.DtoUserIU;
import com.muhammedcbkc.task_management.service.IUserService;

@RestController
@RequestMapping("/api/v1")
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/all-users")
    @Override
    public List<DtoUser> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/save-user")
    @Override
    public DtoUserIU saveUser(@RequestBody DtoUserIU dtoUserIU) {
        return userService.saveUser(dtoUserIU);
    }
    
}
