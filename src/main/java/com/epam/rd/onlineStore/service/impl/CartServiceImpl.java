package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.CartDAO;
import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    @Override
    public Cart findByUserId(long userId) {
        //return null;
        return cartDAO.findByUserId(userId);
    }
}
