package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.OrderDAO;
import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.entity.Order;
import com.epam.rd.onlinestore.entity.User;
import com.epam.rd.onlinestore.service.CartService;
import com.epam.rd.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    CartService cartService;

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public Order save() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            User user = (User) auth.getPrincipal();
            if (user != null) {
                Cart cart = cartService.findByUserId(user.getId());
                if (cart != null) {
                    //return cart.getCartProductItemList();

                    Order order = new Order();
                    return orderDAO.save(order);
                    
                    order.s

                }
            }
        }


    }
}
