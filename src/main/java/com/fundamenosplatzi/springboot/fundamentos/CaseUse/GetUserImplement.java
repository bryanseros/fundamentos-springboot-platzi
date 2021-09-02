package com.fundamenosplatzi.springboot.fundamentos.CaseUse;

import com.fundamenosplatzi.springboot.fundamentos.Service.UserService;
import com.fundamenosplatzi.springboot.fundamentos.entity.User;

import java.util.List;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
