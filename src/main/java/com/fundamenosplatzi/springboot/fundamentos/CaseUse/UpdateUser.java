package com.fundamenosplatzi.springboot.fundamentos.CaseUse;

import com.fundamenosplatzi.springboot.fundamentos.Service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }
}
