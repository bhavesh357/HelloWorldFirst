package com.firstspringapp.controllers;


import com.firstspringapp.exception.GreetingException;
import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;
import com.firstspringapp.service.IGreetingService;
import com.firstspringapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        try {
            User user = service.getUserById(id);
            return user;
        } catch (NoSuchElementException e) {
            throw new GreetingException(GreetingException.GREETING_ERROR.NOT_FOUND);
        }
    }
}
