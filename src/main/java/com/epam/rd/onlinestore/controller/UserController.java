package com.epam.rd.onlinestore.controller;

import com.epam.rd.onlinestore.dao.UserDAO;
import com.epam.rd.onlinestore.entity.User;
import com.epam.rd.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    //private UserDAO userDAO;
    private UserService userService;

    @GetMapping("/registration")
    public String index(Map<String, Object> model)
    {
        return "registration";
    }


    @ResponseBody
    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User getUser(@PathVariable("id") Long id)
    {
        //return userService.findOne(id);
        return userService.findById(id);
    }


    @ResponseBody
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsers()
    {
        List<User> result = new ArrayList<>();
        //userDAO.findAll().forEach(result::add);
        userService.findAll().forEach(result::add);
        return result;
    }

}
