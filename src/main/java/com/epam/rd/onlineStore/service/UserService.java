package com.epam.rd.onlinestore.service;

import com.epam.rd.onlinestore.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    List<User> findAll();

    @Transactional
    User findByUsernameAndPassword(String login, String password);

    @Transactional
    User findByUsername(String username);

    User findById(long id);
}

