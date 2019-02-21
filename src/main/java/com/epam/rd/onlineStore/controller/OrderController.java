package com.epam.rd.onlinestore.controller;

import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.entity.ClientOrder;
import com.epam.rd.onlinestore.service.CartService;
import com.epam.rd.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @GetMapping("/orders")
    //public List<ClientOrder> findAllOrders() {
    public String showClientOrders(Map<String, Object> model) {
        List<ClientOrder> orders = orderService.findAll();
        model.put("orders", orders);
        return "orders";
    }

    @PutMapping("/orders/add")
    @ResponseBody
    @Transactional
    public ClientOrder AddOrder() {
        Cart cart = cartService.getCartForCurrentUser();
        if (cart != null) {
            if (cart.getCartProductItemList().size() > 0) {
                cartService.emptyProductsForCurrentUser();
                return orderService.save();
            }
        }
        return null;
    }
}
