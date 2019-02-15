package com.epam.rd.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "order_product_list")
public class OrderProductItem {

    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;


    private int quantity;


    @EmbeddedId
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private Order order;





}
