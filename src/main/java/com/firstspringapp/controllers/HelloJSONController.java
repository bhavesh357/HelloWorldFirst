package com.firstspringapp.controllers;


import com.firstspringapp.exception.UserException;
import com.firstspringapp.model.User;
import com.firstspringapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/hellojson")
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
            throw new UserException(UserException.USER_ERROR.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public void add(@RequestParam(value = "firstName")  String firstName,@RequestParam(value = "lastName")  String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGreetMessage("Hello ,"+user.toString());
        service.addUser(user);
    }

    @PostMapping("")
    public void add(@RequestBody User user) {
        service.addUser(user);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existingUser = service.getUserById(id);
            service.addUser(user);
        } catch (NoSuchElementException e) {
            throw new UserException(UserException.USER_ERROR.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
