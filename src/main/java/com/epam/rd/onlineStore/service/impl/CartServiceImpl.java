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
        return cartDAO.findByUserId(userId);
    }

    @Override
    public Cart findById(long id) {
        return cartDAO.findById(id);
    }

    @Override
    public Cart addProductToCart(long idCart, product productId) {
        return cartDAO.save(Cart);
    }


}
