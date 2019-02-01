package com.epam.rd.onlineStore.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

//@Component
@Entity
@Table(name = "product", schema = "onlinestorerd", catalog = "")
public class Product {

    private static long maxId;

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    //@Access(AccessType.FIELD)
    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@Column(name = "Categories_idCategories")
    //@OneToMany
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name = "price")
    private double price;

    @Column(name = "image")
    private String image;

    public Product() {
    }

//    public Product(long id, String name, int category, double price, String image) {
//        this.id = id;
//        this.name = name;
//        this.category = category;
//        this.price = price;
//        this.image = image;
//    }
//
//    public void generateId(Product product) {
//        if (product.id == 0) {
//            product.id = ++maxId;
//        }
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static long getMaxId() {
        return maxId;
    }

    public static void setMaxId(long maxId) {
        Product.maxId = maxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
        //return 1;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
