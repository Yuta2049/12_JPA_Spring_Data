package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.PrivilegeDAO;
import com.epam.rd.onlinestore.dao.UserDAO;
import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.entity.Privilege;
import com.epam.rd.onlinestore.entity.User;
import com.epam.rd.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PrivilegeDAO privilegeDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public User findByUsernameAndPassword(String login, String password) {
        return userDAO.findByUsernameAndPasswordhash(login, password);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    @Transactional
    public User findById(long id) {
        return userDAO.findById(id);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    @Transactional
    public User addNewUser(User user) {
        Set<Privilege> privileges = new HashSet<>();
        privileges.add(privilegeDAO.findByName("ROLE_USER"));
        user.setPrivileges(privileges);

//        Cart cart = new Cart();
//        cart.setUser(user);

        return userDAO.save(user);
    }


//    //@Query("SELECT u.privileges FROM User u WHERE u.id = :id")
//    public Set<Privilege> getUserRolesByUserId(long id) {
//        return userDAO.getUserRolesByUserId(id);
//    }

}
