package com.epam.rd.onlinestore.service;

import com.epam.rd.onlinestore.entity.Order;

import java.util.List;

public interface OrderService {

    public List<Order> findAll();

    public Order save();

}
