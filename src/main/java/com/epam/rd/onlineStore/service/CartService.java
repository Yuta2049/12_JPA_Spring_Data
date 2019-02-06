package com.epam.rd.onlinestore.service;

import com.epam.rd.onlinestore.entity.Cart;

public interface CartService {

    Cart findByUserId(long userId);

    Cart findById(long id);
}