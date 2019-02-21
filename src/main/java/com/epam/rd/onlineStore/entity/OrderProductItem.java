package com.epam.rd.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_product_list")
public class OrderProductItem implements Serializable {

    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;


    private int quantity;


    @EmbeddedId
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "order_id", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private ClientOrder clientOrder;

    public OrderProductItem() {
    }

    public OrderProductItem(ClientOrder clientOrder, Product product, int quantity) {
        this.clientOrder = clientOrder;
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

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }
}
