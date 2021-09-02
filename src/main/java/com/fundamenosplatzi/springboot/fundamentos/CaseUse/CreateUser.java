package com.fundamenosplatzi.springboot.fundamentos.CaseUse;

import com.fundamenosplatzi.springboot.fundamentos.Service.UserService;
import com.fundamenosplatzi.springboot.fundamentos.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
