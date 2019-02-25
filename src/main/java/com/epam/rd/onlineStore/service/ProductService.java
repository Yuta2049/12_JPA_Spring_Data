package com.epam.rd.onlinestore.service;

import com.epam.rd.onlinestore.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(long id);

    Product save(Product product);

    boolean deleteById(long id);

    List<Product> findByNameContaining(String productName);
}
