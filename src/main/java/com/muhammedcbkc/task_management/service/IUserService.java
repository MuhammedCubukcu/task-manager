package com.muhammedcbkc.task_management.service;

import java.util.List;

import com.muhammedcbkc.task_management.dto.DtoUser;
import com.muhammedcbkc.task_management.dto.DtoUserIU;

public interface IUserService {
    
    public List<DtoUser> getAllUser();

    public DtoUserIU saveUser(DtoUserIU dtoUserIU);
}
