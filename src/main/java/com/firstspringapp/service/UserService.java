package com.firstspringapp.service;

import com.firstspringapp.model.User;
import com.firstspringapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService implements IUserService{

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserRepository repo;

    @Override
    public User addUser(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> listAll() {
        return repo.findAll();
    }
}
