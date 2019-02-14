package com.epam.rd.onlinestore.entity;


import org.hibernate.annotations.Cascade;

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
    private Long id;


    @OneToOne
    @JoinColumn(name="user_id")
    private User user;


    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "cart",  cascade = {CascadeType.ALL, CascadeType.PERSIST})
    @OneToMany(mappedBy = "cart",  cascade = {CascadeType.ALL, CascadeType.PERSIST})
    //@Cascade(CascadeType.SAVE_UPDATE)
    private List<ProductItem> productItemList;

    public Cart() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //@OneToMany(cascade=ALL, mappedBy="cart")
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
