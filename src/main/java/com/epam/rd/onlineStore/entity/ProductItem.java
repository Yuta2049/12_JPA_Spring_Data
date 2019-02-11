package com.epam.rd.onlinestore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_product_list")
//@IdClass(Cart.class)
//@Embeddable
//@IdClass(ProductItem.PK.class)
@IdClass(ProductItemPK.class)
public class ProductItem implements Serializable {

    @EmbeddedId
    //@Id
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;


    private int quantity;


    //@Id
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;


    public ProductItem() {
    }

    public ProductItem(Cart cart, Product product, int quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;

    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
