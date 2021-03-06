package com.epam.rd.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_product_list")
//@IdClass(Cart.class)
//@Embeddable
//@IdClass(ProductItem.PK.class)
@IdClass(ProductItemPK.class)
public class CartProductItem implements Serializable {

    @EmbeddedId
    //@Id
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;


    private int quantity;


    //@Id
    @EmbeddedId
    //@ManyToOne
//    @JoinColumn(name="cart_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonIgnore
    private Cart cart;


    public CartProductItem() {
    }

    public CartProductItem(Cart cart, Product product, int quantity) {
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

//    @ManyToOne
//    @JoinColumn(name="cart_id", nullable=false)
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
