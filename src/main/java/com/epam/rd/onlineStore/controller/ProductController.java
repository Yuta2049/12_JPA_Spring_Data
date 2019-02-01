package com.epam.rd.onlineStore.controller;

import com.epam.rd.onlineStore.model.Category;
import com.epam.rd.onlineStore.model.Product;
import com.epam.rd.onlineStore.service.IProductService;
import com.epam.rd.onlineStore.service.impl.CategoryService;
import com.epam.rd.onlineStore.service.impl.ProductService;
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
