package com.epam.rd.onlinestore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_product_list")
//@IdClass(Cart.class)
//@Embeddable
//@IdClass(ProductItem.PK.class)
public class ProductItem implements Serializable {

    public static class PK implements Serializable  {
        private Cart cart;
        private Product product;
    }
//
//    //@ManyToMany
    @EmbeddedId
    //@Id
    //@ManyToMany
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;


    private int quantity;

//    //@Id
//    @EmbeddedId
//    @ManyToOne
//    @JoinColumn(name="cart_id")
//    //@JoinColumn(name="cart_id", referencedColumnName="id")
////    //@JoinColumn(name="user_id")
//    //@JoinColumn(name="user_id", referencedColumnName="cart_user_id")
//    //@Column(name="cart_user_id")
//    private Cart cart;
////


    public ProductItem() {
    }

//    public Cart getCart() {
//        return cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }

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
