package com.fundamenosplatzi.springboot.fundamentos.Configuration;

import com.fundamenosplatzi.springboot.fundamentos.CaseUse.GetUser;
import com.fundamenosplatzi.springboot.fundamentos.CaseUse.GetUserImplement;
import com.fundamenosplatzi.springboot.fundamentos.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
