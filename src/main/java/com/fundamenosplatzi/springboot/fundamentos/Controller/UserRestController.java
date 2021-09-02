package com.fundamenosplatzi.springboot.fundamentos.Controller;

import com.fundamenosplatzi.springboot.fundamentos.CaseUse.CreateUser;
import com.fundamenosplatzi.springboot.fundamentos.CaseUse.GetUser;
import com.fundamenosplatzi.springboot.fundamentos.entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //servicio create, get, delete, update

    private GetUser getUser;
    private CreateUser createUser;

    public UserRestController(GetUser getUser, CreateUser createUser) {
        this.getUser = getUser;
        this.createUser = createUser;
    }

    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }

    /*@PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser));

    }*/
}
