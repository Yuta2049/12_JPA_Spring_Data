package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.CartDAO;
import com.epam.rd.onlinestore.dao.ProductItemDAO;
import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.entity.Product;
import com.epam.rd.onlinestore.entity.CartProductItem;
import com.epam.rd.onlinestore.entity.User;
import com.epam.rd.onlinestore.service.CartService;
import com.epam.rd.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private ProductItemDAO productItemDAO;

    @Autowired
    private ProductService productService;

    @Override
    public Cart findByUserId(long userId) {
        return cartDAO.findByUserId(userId);
    }

    @Override
    public Cart findById(long id) {
        return cartDAO.findById(id);
    }

    @Override
    public Cart addProductToCart(long idCart, long productId) {
        Product product = productService.findById(productId);
        Cart cart = findById(idCart);
        for (CartProductItem cartProductItem : cart.getCartProductItemList()) {
            if (cartProductItem.getProduct().equals(product)) {
                cartProductItem.setQuantity(cartProductItem.getQuantity() + 1);
                return cartDAO.save(cart);
            }
        }
        CartProductItem cartProductItem = new CartProductItem(cart, product, 1);
        List<CartProductItem> cartProductItemList = cart.getCartProductItemList();
        cartProductItemList.add(cartProductItem);
        cart.setCartProductItemList(cartProductItemList);
        return cartDAO.save(cart);
    }

    @Override
    public Cart getCartForCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            User user = (User) auth.getPrincipal();
            if (user != null) {
                Cart cart = findByUserId(user.getId());
                if (cart != null) {
                    return cart;
                }
            }
        }
        return null;
    }

    @Override
    public Cart emptyProductsForCurrentUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            User user = (User) auth.getPrincipal();
            if (user != null) {
                Cart cart = findByUserId(user.getId());
                cart.setCartProductItemList(new ArrayList<CartProductItem>());
                System.out.println("emptyProductsForCurrentUser");
                return cartDAO.save(cart);
            }
        }
        return null;
    }

}
