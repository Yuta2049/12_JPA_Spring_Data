package com.epam.rd.onlinestore.service;

import com.epam.rd.onlinestore.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByUsernameAndPassword(String login, String password);

    User findByUsername(String username);
}

