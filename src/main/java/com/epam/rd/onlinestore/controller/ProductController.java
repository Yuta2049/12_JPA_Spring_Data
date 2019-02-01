package com.epam.rd.onlinestore.controller;

import com.epam.rd.onlinestore.model.Category;
import com.epam.rd.onlinestore.model.Product;
import com.epam.rd.onlinestore.service.IProductService;
import com.epam.rd.onlinestore.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Map<String, Object> model)
    {
        List<Product> products = productService.findAll();
        List<Category> categories = categoryService.findAll();

        model.put("products", products);
        model.put("categories", categories);

        return "index";
    }

    @RequestMapping("/header.html")
    public String header() {
        return "header";
    }

    @RequestMapping("/footer.html")
    public String footer() {
        return "footer";
    }
}
