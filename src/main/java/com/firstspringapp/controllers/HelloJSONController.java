package com.firstspringapp.controllers;


import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;
import com.firstspringapp.service.IGreetingService;
import com.firstspringapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/helloJSON")
public class HelloJSONController {

    @Autowired
    private IUserService service;

    @RequestMapping(value = {"","/","/home"})
    public User sayHello(){
        User user = new User();
        user.setGreetMessage("Hello World");
        return service.addUser(user);
    }

    @GetMapping("/all")
    public List<User> list() {
        return service.listAll();
    }
}
