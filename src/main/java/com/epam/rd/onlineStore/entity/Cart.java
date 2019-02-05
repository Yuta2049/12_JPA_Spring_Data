package com.epam.rd.onlinestore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cart", schema = "onlinestorerd", catalog = "")
//@SecondaryTable(name="cartProductList", schema = "onlinestorerd", catalog = "")
public class Cart implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name="user_id")
    //@Column(name="user_id", )
    private User user;

//    @OneToOne
//    @JoinColumn(name="user_id")

//    @OneToMany(fetch = FetchType.LAZY,
//            mappedBy = "cart",
//            cascade = CascadeType.ALL)
    //@Column(table = "cartProductList")
    //@OneToMany
    //@Column(name="zipcode", table="cartProductList")
    //@ElementCollection( targetClass = ProductItem.class )
    //@Column(name="cartUserId", table="cartProductList")
    //@JoinColumn(name="cart_user_id", table="cartProductList")
    //@Column(name="cart_user_id", table="cartProductList")
    //@OneToMany
    @OneToMany(mappedBy="cart")
    //@JoinColumn(name="user_id", referencedColumnName="cart_user_id")
    private List<ProductItem> productItemList;

    public Cart() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProductItem> getProductItemList() {
        return productItemList;
    }

    public void setProductItemList(List<ProductItem> productItemList) {
        this.productItemList = productItemList;
    }
}
