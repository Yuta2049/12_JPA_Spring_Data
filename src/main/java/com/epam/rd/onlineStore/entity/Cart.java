package com.epam.rd.onlinestore.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    private List<CartProductItem> cartProductItemList;

    public Cart() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //@OneToMany(cascade=ALL, mappedBy="cart")
    public List<CartProductItem> getCartProductItemList() {
        return cartProductItemList;
    }

    public void setCartProductItemList(List<CartProductItem> cartProductItemList) {
        this.cartProductItemList = cartProductItemList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
