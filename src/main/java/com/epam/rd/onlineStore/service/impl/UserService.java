package com.epam.rd.onlineStore.service.impl;

import com.epam.rd.onlineStore.dao.UserDAO;
import com.epam.rd.onlineStore.model.User;
import com.epam.rd.onlineStore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDAO userDAO = new UserDAO();

//    public UserService() {}

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userDAO.findByUsernameAndPassword(login, password);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }


}
