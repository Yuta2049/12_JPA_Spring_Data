package com.epam.rd.onlinestore.controller;

import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

//    @GetMapping(value = "/cart/{userId}")
//    public Cart showCart(@PathVariable("userId") long userId) {
//        return this.cartService.findByUserId(userId);
//    }

    @GetMapping(value = "/cart/{id}")
    public Cart showCart(@PathVariable("id") long id) {
        return this.cartService.findById(id);
    }


    @GetMapping(value = "/cart/{id}/add/{productId}")
    public Cart addProductToCart(@PathVariable("id") long id, @PathVariable("productId") long productId) {
        System.out.println(id);
        System.out.println(productId);
        return this.cartService.addProductToCart(id, productId);
    }

}
