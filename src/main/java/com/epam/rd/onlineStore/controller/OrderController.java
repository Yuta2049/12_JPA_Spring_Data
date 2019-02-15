package com.epam.rd.onlinestore.controller;

import com.epam.rd.onlinestore.entity.Order;
import com.epam.rd.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        return orderService.findAll();
    }

    @PutMapping("/orders/add")
    public Order AddOrder(){
        return orderService.save();
    }




}
