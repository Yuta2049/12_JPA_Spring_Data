package com.epam.rd.onlinestore.service;

import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.entity.User;

public interface CartService {

    Cart findByUserId(long userId);

    Cart findByUser(User user);

    Cart findById(long id);

    Cart getCartForCurrentUser();

    Cart addProductToCart(long productId);

    Cart emptyProductsForCurrentUser();

}
