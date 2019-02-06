package com.epam.rd.onlinestore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
//@Table(name = "cart", schema = "onlinestorerd", catalog = "")
@Table(name = "cart")
//@SecondaryTable(name="cartProductList", schema = "onlinestorerd", catalog = "")
//@IdClass(ProductItem.class)
//@Embeddable
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;


    @OneToOne
    //@Column(name="user_id")
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
    //@JoinColumn(name="cart_user_id", referencedColumnName="user_id")
    //@Column(name="cart_user_id", table="cartProductList")
    //@Column(name="user_id")
    //@OneToMany
    //@OneToMany(mappedBy="cart")
    //@JoinColumn(name="user_id", referencedColumnName="cart_user_id")
    @OneToMany
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    //@OneToMany(mappedBy = "cart", cascade = ALL)
    //@JoinColumn(name = "user_id", referencedColumnName = "cart_user_id")
    //@ManyToMany(cascade = CascadeType.ALL)
    //@OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "cart_product_list",
//            joinColumns = @JoinColumn(name = "cart_user_id", referencedColumnName = "user_id"))
    //@JoinColumn(name = "cart_user_id", referencedColumnName = "user_id")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
