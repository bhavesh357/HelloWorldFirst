package com.firstspringapp.controllers;

import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;
import com.firstspringapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World") String name){
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }
}
