package com.epam.rd.onlinestore.controller;

import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.entity.CartProductItem;
import com.epam.rd.onlinestore.entity.User;
import com.epam.rd.onlinestore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public List<CartProductItem> getProductInTheCartForCurrentUser() {
        return cartService.getCartForCurrentUser().getCartProductItemList();
    }


    @PutMapping(value = "/cart/add/{productId}")
    public Cart addProductToCart(@PathVariable("productId") long productId) {

        return cartService.addProductToCart(productId);
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            User user = (User) auth.getPrincipal();
//            if (user != null) {
//                return cartService.addProductToCart(user.getId(), productId);
//            }
//        }
//        return null;
    }

}
