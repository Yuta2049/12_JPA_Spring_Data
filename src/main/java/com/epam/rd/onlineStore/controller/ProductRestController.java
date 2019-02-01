package com.epam.rd.onlineStore.controller;

import com.epam.rd.onlineStore.model.Product;
import com.epam.rd.onlineStore.service.IProductService;
import com.epam.rd.onlineStore.service.impl.CategoryService;
import com.epam.rd.onlineStore.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @Autowired
    private CategoryService categoryService;

//    @PostMapping("/products/new")
//    public boolean processCreationForm(@RequestBody Product product) {
//        return this.productService.add(product);
//    }
//
//    @GetMapping(value = "/products/{productId}/edit")
//    public Product editProduct(@PathVariable("productId") long productId) {
//        return this.productService.findById(productId);
//    }
//
//    @PutMapping("/products/{productId}/edit")
//    public Product editProductSave(@RequestBody Product product) {
//        return this.productService.save(product);
//    }
//
//
//    @DeleteMapping ("/products/{productId}/delete")
//    public boolean deleteProduct(@PathVariable("productId") long productId) {
//        return this.productService.deleteById(productId);
//    }
//
//    //@RequestMapping("/products/search")
//    @GetMapping("/products/search")
//    public List<Product> searchProductsByName(@RequestParam(value = "productName") String productName) {
//        return this.productService.findByName(productName);
//    }

}
