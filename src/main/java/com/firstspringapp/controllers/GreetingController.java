package com.firstspringapp.controllers;

import com.firstspringapp.exception.GreetingException;
import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;
import com.firstspringapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService service;

    @GetMapping("")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World") String name){
        User user = new User();
        user.setFirstName(name);
        return service.addGreeting(user);
    }

    @GetMapping("/all")
    public List<Greeting> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Greeting get(@PathVariable Integer id) {
        try {
            Greeting greeting = service.getGreetingById(id);
            return greeting;
        } catch (NoSuchElementException e) {
            throw new GreetingException(GreetingException.GREETING_ERROR.NOT_FOUND);
        }
    }
}
