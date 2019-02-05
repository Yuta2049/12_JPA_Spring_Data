package com.epam.rd.onlinestore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cartProductList")
public class ProductItem implements Serializable {

    //@ManyToMany
    private Product product;


    private int quantity;

    @Id
    @ManyToOne
    //@JoinColumn(name="cart_user_id")
    @JoinColumn(name="cart_user_id", referencedColumnName="user_id")
    private Cart cart;

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
}
