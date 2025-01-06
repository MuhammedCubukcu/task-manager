package com.muhammedcbkc.task_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhammedcbkc.task_management.dto.DtoUser;
import com.muhammedcbkc.task_management.dto.DtoUserIU;
import com.muhammedcbkc.task_management.entities.User;
import com.muhammedcbkc.task_management.repository.UserRepository;
import com.muhammedcbkc.task_management.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<DtoUser> getAllUser() {
        return userRepository.findAll().stream()
                .map(user -> {
                    DtoUser dtoUser = new DtoUser();
                    dtoUser.setUsername(user.getUsername());
                    dtoUser.setEmail(user.getEmail());
                    return dtoUser;
                })
                .collect(Collectors.toList());
    }

    @Override
    public DtoUserIU saveUser(DtoUserIU dtoUserIU) {
        User user = new User();
        user.setUsername(dtoUserIU.getUsername());
        user.setEmail(dtoUserIU.getEmail());
        user.setPassword(dtoUserIU.getPassword());
        
        User savedUser = userRepository.save(user);
        
        DtoUserIU savedDto = new DtoUserIU();
        savedDto.setUsername(savedUser.getUsername());
        savedDto.setEmail(savedUser.getEmail());
        savedDto.setPassword(savedUser.getPassword());
        
        return savedDto;
    }



    
}
