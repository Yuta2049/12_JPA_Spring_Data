package com.epam.rd.onlinestore.service;

import com.epam.rd.onlinestore.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findByUsernameAndPassword(String login, String password);

    User findByUsername(String username);
}
