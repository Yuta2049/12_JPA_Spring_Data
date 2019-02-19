package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.CartDAO;
import com.epam.rd.onlinestore.dao.ProductItemDAO;
import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.entity.Product;
import com.epam.rd.onlinestore.entity.CartProductItem;
import com.epam.rd.onlinestore.service.CartService;
import com.epam.rd.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                cartProductItem.setQuantity(cartProductItem.getQuantity()+1);
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
    public Cart deleteProductsFromCart(long userId) {

        Cart cart = findById(idCart);
        List<CartProductItem> cartProductItemList = cart.getCart

        return cartDAO.save(cart);
    }

}
