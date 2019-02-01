package com.epam.rd.onlineStore.service;

import com.epam.rd.onlineStore.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findByLoginAndPassword(String login, String password);

    User findUserByUsername(String username);
}
