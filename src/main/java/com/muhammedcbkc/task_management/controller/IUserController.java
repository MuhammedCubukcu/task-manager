package com.muhammedcbkc.task_management.controller;

import java.util.List;

import com.muhammedcbkc.task_management.dto.DtoUser;
import com.muhammedcbkc.task_management.dto.DtoUserIU;

public interface IUserController {
    
    public List<DtoUser> getAllUser();

    public DtoUserIU saveUser(DtoUserIU dtoUserIU);
    
}
