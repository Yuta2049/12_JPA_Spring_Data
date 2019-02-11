package com.epam.rd.onlinestore.entity;

import javax.persistence.*;
import java.io.Serializable;

//@Component
@Entity
@Table(name = "product", schema = "onlinestorerd", catalog = "")
public class Product implements Serializable {

    //private static long maxId;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    //@Access(AccessType.FIELD)
    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@Column(name = "Categories_idCategories")
    @ManyToOne
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

//    public static long getMaxId() {
//        return maxId;
//    }
//
//    public static void setMaxId(long maxId) {
//        Product.maxId = maxId;
//    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        if (!getCategory().equals(product.getCategory())) return false;
        return getImage() != null ? getImage().equals(product.getImage()) : product.getImage() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getCategory().hashCode();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        return result;
    }
}
