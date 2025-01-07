package com.muhammedcbkc.task_management.controller.impl;

import com.muhammedcbkc.task_management.controller.IUserController;
import com.muhammedcbkc.task_management.dto.ApiResponse;
import com.muhammedcbkc.task_management.dto.DtoUser;
import com.muhammedcbkc.task_management.dto.DtoUserIU;
import com.muhammedcbkc.task_management.exception.UserNotFoundException;
import com.muhammedcbkc.task_management.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Management", description = "Operations related to user management")
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    @Override
    @Operation(summary = "Retrieve all users", description = "Fetch a list of all users")
    public ApiResponse<List<DtoUser>> getAllUser() {
        List<DtoUser> users = userService.getAllUser();
        return new ApiResponse<>(true, "Users retrieved successfully", users);
    }

    @GetMapping("/{id}")
    @Override
    @Operation(summary = "Retrieve a user by ID", description = "Fetch a specific user by their ID")
    public ApiResponse<DtoUser> getUserById(@PathVariable Long id) {
        DtoUser user = userService.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        return new ApiResponse<>(true, "User retrieved successfully", user);
    }

    @PostMapping
    @Override
    @Operation(summary = "Create a new user", description = "Save a new user to the database")
    public ApiResponse<DtoUserIU> saveUser(@RequestBody DtoUserIU dtoUserIU) {
        DtoUserIU savedUser = userService.saveUser(dtoUserIU);
        return new ApiResponse<>(true, "User saved successfully", savedUser);
    }

    @DeleteMapping("/{id}")
    @Override
    @Operation(summary = "Delete a user by ID", description = "Remove a user from the database by their ID")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ApiResponse<>(true, "User deleted successfully", null);
    }

    @PutMapping("/{id}")
    @Override
    @Operation(summary = "Update a user by ID", description = "Update an existing user's details")
    public ApiResponse<DtoUserIU> updateUser(@PathVariable Long id, @RequestBody DtoUserIU dtoUserIU) {
        DtoUserIU updatedUser = userService.updateUser(id, dtoUserIU);
        return new ApiResponse<>(true, "User updated successfully", updatedUser);
    }
}
