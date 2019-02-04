package com.epam.rd.onlinestore.service;

import com.epam.rd.onlinestore.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(long id);

    Product save(Product product);

    boolean deleteById(long id);

    //boolean add(Product product);

    List<Product> findByName(String productName);

//    List<Product> findByPrice(String productPrice);
}
