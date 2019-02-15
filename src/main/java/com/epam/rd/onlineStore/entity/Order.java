package com.epam.rd.onlinestore.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Order {

    @Id
    private long Id;


    private LocalDate date;


    @OneToMany
    @JoinColumn(name="user_id")
    private User user;


    @OneToMany(mappedBy = "order",  cascade = {CascadeType.ALL, CascadeType.PERSIST})
    private List<OrderProductItem> cartProductItemList;


    public Order() {
    }

    public Order(long id, LocalDate date, User user) {
        Id = id;
        this.date = date;
        this.user = user;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderProductItem> getCartProductItemList() {
        return cartProductItemList;
    }

    public void setCartProductItemList(List<OrderProductItem> cartProductItemList) {
        this.cartProductItemList = cartProductItemList;
    }

}
