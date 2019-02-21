package com.epam.rd.onlinestore.controller;

import com.epam.rd.onlinestore.dao.UserDAO;
import com.epam.rd.onlinestore.entity.User;
import com.epam.rd.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    //private UserDAO userDAO;
    private UserService userService;

    @GetMapping("/users/registration")
    public String showRegistrationForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "registration";
    }


    @PostMapping("/users/registration")
    public String registerNewUser(@ModelAttribute User user, BindingResult result, Model model) {
//    public String showRegistrationForm222(Map<String, Object> model) {
        //System.out.println("Перешли на /users/add - get");
        if (result.hasErrors()) {
            return "redirect:/";
        } else {
            this.userService.save(user);
            return "redirect:/";
        }
    }

//    @PutMapping("/users/registration")
//    public String showRegistrationForm333(Map<String, Object> model) {
//        System.out.println("Тыкнули в регистрацию кнопку 333");
//        //User user = new User();
//        //model.put("user", user);
//        return "redirect:/";
//    }

//    //@ResponseBody
//    //@PostMapping("/users/add")
//    @GetMapping("/users/add")
//    public String addUser222(@ModelAttribute User user, BindingResult result, Model model)
//    {
//        System.out.println("Перешли на /users/add - get");
//        if (result.hasErrors()) {
//            return "redirect:/";
//        } else {
//            this.userService.save(user);
//            return "redirect:/";
//        }
//    }


//    //@ResponseBody
//    //@PostMapping("/users/add")
//    @PostMapping("/users/add")
//    public String addUser(@ModelAttribute User user, BindingResult result, Model model)
//    {
//        System.out.println("Перешли на /users/add");
//        if (result.hasErrors()) {
//            return "redirect:/";
//        } else {
//            this.userService.save(user);
//            return "redirect:/";
//        }
//    }


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
        System.out.println("Перешли на /users");
        List<User> result = new ArrayList<>();
        //userDAO.findAll().forEach(result::add);
        userService.findAll().forEach(result::add);
        return result;
    }

}
