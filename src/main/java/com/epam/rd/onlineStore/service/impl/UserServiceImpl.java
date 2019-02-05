package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.UserDAO;
import com.epam.rd.onlinestore.entity.User;
import com.epam.rd.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findByUsernameAndPassword(String login, String password) {
        return userDAO.findByUsernameAndPasswordhash(login, password);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

}
