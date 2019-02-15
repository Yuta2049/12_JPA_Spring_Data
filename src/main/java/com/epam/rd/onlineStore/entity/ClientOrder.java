package com.epam.rd.onlinestore.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientOrder")
public class ClientOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;


    private LocalDate date;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @OneToMany(mappedBy = "clientOrder",  cascade = {CascadeType.ALL, CascadeType.PERSIST})
    private List<OrderProductItem> orderProductItemList;


    public ClientOrder() {
    }

    public ClientOrder(long id, LocalDate date, User user) {
        id = id;
        this.date = date;
        this.user = user;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
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

    public List<OrderProductItem> getOrderProductItemList() {
        return orderProductItemList;
    }

    public void setOrderProductItemList(List<OrderProductItem> orderProductItemList) {
        this.orderProductItemList = orderProductItemList;
    }


    public void setOrderProductItemListFromCartProductItemList(List<CartProductItem> cartProductItemList) {
        List<OrderProductItem> orderProductItemList2 = new ArrayList<>();
        for(CartProductItem item : cartProductItemList) {
            orderProductItemList2.add(new OrderProductItem(this, item.getProduct(), item.getQuantity()));
        }
        this.orderProductItemList = orderProductItemList2;
    }
}
