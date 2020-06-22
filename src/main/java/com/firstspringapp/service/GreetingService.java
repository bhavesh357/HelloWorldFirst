package com.firstspringapp.service;

import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;
import com.firstspringapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String template= "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository repo;

    public List<Greeting> listAll(){
        return repo.findAll();
    }

    @Override
    public void save(Greeting greeting) {
        repo.save(greeting);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(Long.valueOf(id));
    }

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return repo.save(new Greeting(counter.incrementAndGet(),message));
    }

    @Override
    public Greeting getGreetingById(long id) {
        return repo.findById(id).get();
    }
}
