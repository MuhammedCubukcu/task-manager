package com.muhammedcbkc.task_management.controller.impl;

import com.muhammedcbkc.task_management.controller.IUserController;
import com.muhammedcbkc.task_management.dto.ApiResponse;
import com.muhammedcbkc.task_management.dto.DtoUser;
import com.muhammedcbkc.task_management.dto.DtoUserIU;
import com.muhammedcbkc.task_management.exception.UserNotFoundException;
import com.muhammedcbkc.task_management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/all-users")
    @Override
    public ApiResponse<List<DtoUser>> getAllUser() {
        List<DtoUser> users = userService.getAllUser();
        return new ApiResponse<>(true, "Users retrieved successfully", users);
    }

    @GetMapping("/user/{id}")
    @Override
    public ApiResponse<DtoUser> getUserById(@PathVariable Long id) {
        DtoUser user = userService.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        return new ApiResponse<>(true, "User retrieved successfully", user);
    }

    @PostMapping("/save-user")
    @Override
    public ApiResponse<DtoUserIU> saveUser(@RequestBody DtoUserIU dtoUserIU) {
        DtoUserIU savedUser = userService.saveUser(dtoUserIU);
        return new ApiResponse<>(true, "User saved successfully", savedUser);
    }

    @DeleteMapping("/delete-user/{id}")
    @Override
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ApiResponse<>(true, "User deleted successfully", null);
    }

    @PutMapping("/update-user/{id}")
    @Override
    public ApiResponse<DtoUserIU> updateUser(@PathVariable Long id, @RequestBody DtoUserIU dtoUserIU) {
        DtoUserIU updatedUser = userService.updateUser(id, dtoUserIU);
        return new ApiResponse<>(true, "User updated successfully", updatedUser);
    }
}
