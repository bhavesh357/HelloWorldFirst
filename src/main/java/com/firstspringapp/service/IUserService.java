package com.firstspringapp.service;

import com.firstspringapp.model.User;

import java.util.List;

public interface IUserService {
    User addUser(User user);

    List<User> listAll();

    User getUserById(Integer id);

}
