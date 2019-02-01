package com.epam.rd.onlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/registration")
    public String index(Map<String, Object> model)
    {
        return "registration";
    }


}
