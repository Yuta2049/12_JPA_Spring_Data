package com.epam.rd.onlinestore.controller;

import com.epam.rd.onlinestore.entity.ClientOrder;
import com.epam.rd.onlinestore.service.CartService;
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

    @Autowired
    private CartService cartService;

    @GetMapping("/orders")
    public List<ClientOrder> findAllOrders(){
        return orderService.findAll();
    }

    @PutMapping("/orders/add")
    public ClientOrder AddOrder(){
        //return orderService.save();
        orderService.save();
        cartService.deleteProductsByUserID();
    }




}
