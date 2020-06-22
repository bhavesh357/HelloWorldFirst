package com.firstspringapp.service;

import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;

import java.util.List;


public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);

    List<Greeting> listAll();

    void save(Greeting greeting);

    void delete(Integer id);
}
