package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    List<Product> findAll();

//    public Product save(Product product) {
//        Product productInList = findById(product.getId());
//        int index = productList.indexOf(productInList);
//        productList.set(index, product);
//        return product;
//    }
    Product save(Product product);


//
//    public Product findById(long id) {
//        return productList.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
//    }
//
    Product findById(long id);


//    public boolean deleteById(long id) {
//        return productList.removeIf(x -> x.getId()==id);
//    }
    boolean deleteById(long id);


//    public boolean add(Product product) {
//        product.generateId(product);
//        return productList.add(product);
//    }
    //boolean save(Product product);

//
//    public List<Product> findByName(String productName) {
//        return productList.stream().filter(o->o.getName().contains(productName)).collect(Collectors.toList());
//    }
    List<Product> findByName(String productName);

//
//    public List<Product> findByPrice(String productPrice) {
//        return productList.stream().filter(o->String.valueOf(o.getPrice()).contains(productPrice)).collect(Collectors.toList());
//    }

}
