package com.epam.rd.onlinestore.controller;

import com.epam.rd.onlinestore.model.Category;
import com.epam.rd.onlinestore.model.Product;
import com.epam.rd.onlinestore.service.IProductService;
import com.epam.rd.onlinestore.service.impl.CategoryService;
import com.epam.rd.onlinestore.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@Controller
public class OldProductController {

    @Autowired
    private IProductService productService = new ProductService();

    @Autowired
    private CategoryService categoryService = new CategoryService();

    @GetMapping("/")
    public String index(Map<String, Object> model)
    {
         List<Product> products = productService.findAll();
        List<Category> categories = categoryService.findAll();

        model.put("products", products);
        model.put("categories", categories);

        return "index";
    }

//    @RequestMapping(value = "/products/new", method = RequestMethod.GET)
//    public //@ResponseBody
//    String addNewProduct(Model model) {
//        model.addAttribute("product", new Product());
//        model.addAttribute("isNewProduct", true);
//        return "fragments/createOrUpdateProductForm:: productEdit";
//    }
//
//    @PostMapping("/products/new")
//    public String processCreationForm(@ModelAttribute Product product, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "redirect:/";
//        } else {
//            this.productService.add(product);
//            return "redirect:/";
//        }
//    }
//
//    @RequestMapping(value = "/products/{productId}/edit", method = RequestMethod.GET)
//    public //@ResponseBody
//    String editProduct(Model model, @PathVariable("productId") long productId) {
//        model.addAttribute("product", this.productService.findById(productId));
//        model.addAttribute("isNewProduct", false);
//        return "fragments/createOrUpdateProductForm :: productEdit";
//    }
//
//    @PostMapping("/products/{productId}/edit")
//    public String processUpdateOwnerForm(@ModelAttribute Product product, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "redirect:/";
//        } else {
//            this.productService.save(product);
//            return "redirect:/";
//        }
//    }
//
//    @RequestMapping("/products/{productId}/delete")
//    public String deleteProduct(@PathVariable("productId") long productId, Model model) {
//        this.productService.deleteById(productId);
//        return "redirect:/";
//    }
//
//    @RequestMapping("/products/search")
//    public String searchProductsByName(@RequestParam(value = "productName") String productName, Model model) {
//        List<Product> productList = this.productService.findByName(productName);
//        model.addAttribute("productList", productList);
//        return "fragments/findProductForm :: productFind";
//    }


    @RequestMapping("/header.html")
    public String header() {
        return "header";
    }

    @RequestMapping("/footer.html")
    public String footer() {
        return "footer";
    }
}
