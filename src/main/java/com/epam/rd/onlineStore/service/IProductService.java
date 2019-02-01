package com.epam.rd.onlineStore.service;

import com.epam.rd.onlineStore.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

//    Product findById(long id);
//
//    Product save(Product product);
//
//    boolean deleteById(long id);
//
//    boolean add(Product product);
//
//    List<Product> findByName(String productName);
//
//    List<Product> findByPrice(String productPrice);
}
