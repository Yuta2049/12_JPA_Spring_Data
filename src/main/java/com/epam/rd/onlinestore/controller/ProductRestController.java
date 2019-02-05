package com.epam.rd.onlinestore.controller;

import com.epam.rd.onlinestore.model.Product;
import com.epam.rd.onlinestore.service.ProductService;
import com.epam.rd.onlinestore.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/products/new")
    //public boolean processCreationForm(@RequestBody Product product) {
    public Product processCreationForm(@RequestBody Product product) {
        //return this.productService.add(product);
        return this.productService.save(product);
        //return this.productService.updateProduct(product);
    }

    @GetMapping(value = "/products/{productId}/edit")
    public Product editProduct(@PathVariable("productId") long productId) {
        return this.productService.findById(productId);
    }

    @PutMapping("/products/{productId}/edit")
    public Product editProductSave(@RequestBody Product product) {
        return this.productService.save(product);
        //return this.productService.updateProduct(product);
    }


    @DeleteMapping ("/products/{productId}/delete")
    public boolean deleteProduct(@PathVariable("productId") long productId) {
        return this.productService.deleteById(productId);
    }

//    //@RequestMapping("/products/search")
//    @GetMapping("/products/search")
//    public List<Product> searchProductsByName(@RequestParam(value = "productName") String productName) {
//        return this.productService.findByName(productName);
//    }

}
