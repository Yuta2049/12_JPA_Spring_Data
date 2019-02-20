package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.OrderDAO;
import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.entity.ClientOrder;
import com.epam.rd.onlinestore.entity.User;
import com.epam.rd.onlinestore.service.CartService;
import com.epam.rd.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CartService cartService;

    @Override
    public List<ClientOrder> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public ClientOrder save() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            User user = (User) auth.getPrincipal();
            if (user != null) {
                Cart cart = cartService.findByUserId(user.getId());
                if (cart != null && cart.getCartProductItemList().size() > 0) {
                    ClientOrder clientOrder = new ClientOrder();
                    clientOrder.setDate(LocalDate.now());
                    clientOrder.setUser(user);
                    clientOrder.setOrderProductItemListFromCartProductItemList(cart.getCartProductItemList());

                    return orderDAO.save(clientOrder);
                }
            }
        }
        return null;
    }
}
