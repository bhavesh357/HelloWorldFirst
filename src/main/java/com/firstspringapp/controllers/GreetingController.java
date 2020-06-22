package com.firstspringapp.controllers;

import com.firstspringapp.exception.GreetingException;
import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;
import com.firstspringapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("")
    public void add(@RequestBody Greeting greeting) {
        service.save(greeting);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Greeting person, @PathVariable Integer id) {
        try {
            Greeting existGreeting = service.getGreetingById(id);
            service.save(person);
        } catch (NoSuchElementException e) {
            throw new GreetingException(GreetingException.GREETING_ERROR.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
