package com.epam.rd.onlinestore.entity;

import java.io.Serializable;

public class ProductItemPK implements Serializable {

    private Cart cart;
    private Product product;

    public ProductItemPK() {
    }

    public ProductItemPK(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
