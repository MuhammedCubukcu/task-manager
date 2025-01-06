package com.muhammedcbkc.task_management.controller;

import java.util.List;

import com.muhammedcbkc.task_management.dto.ApiResponse;
import com.muhammedcbkc.task_management.dto.DtoUser;
import com.muhammedcbkc.task_management.dto.DtoUserIU;

public interface IUserController {
    
    public ApiResponse<List<DtoUser>> getAllUser();

    public ApiResponse<DtoUserIU> saveUser(DtoUserIU dtoUserIU);

    public ApiResponse<DtoUser> getUserById(Long id);

    public ApiResponse<Void> deleteUser(Long id);

    public ApiResponse<DtoUserIU> updateUser(Long id, DtoUserIU dtoUserIU);
}