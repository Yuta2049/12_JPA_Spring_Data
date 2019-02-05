package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.ProductDAO;
import com.epam.rd.onlinestore.model.Product;
import com.epam.rd.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

//    public ProductService() {}

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product save(Product product) {
    //public Product updateProduct(Product product) {
        return productDAO.save(product);
        //return productDAO.updateProduct(product);
    }

    @Override
    public Product findById(long id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean deleteById(long id) {
        return productDAO.deleteById(id);
    }

//    @Override
//    //public boolean add(Product product) {
//    public Product add(Product product) {
//        return productDAO.save(product);
//    }

    @Override
    public List<Product> findByName(String productName) {
        return productDAO.findByName(productName);
    }

//    @Override
//    public List<Product> findByPrice(String productPrice) {
//        return productDAO.findByPrice(productPrice);
//    }
}