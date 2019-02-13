package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.CartDAO;
import com.epam.rd.onlinestore.dao.ProductItemDAO;
import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.entity.Product;
import com.epam.rd.onlinestore.entity.ProductItem;
import com.epam.rd.onlinestore.service.CartService;
import com.epam.rd.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private ProductItemDAO productItemDAO;

    @Autowired
    private ProductService productService;

    @Override
    public Cart findByUserId(long userId) {
        return cartDAO.findByUserId(userId);
    }

    @Override
    public Cart findById(long id) {
        return cartDAO.findById(id);
    }

    @Override
    public Cart addProductToCart(long idCart, long productId) {

        Product product = productService.findById(productId);
        Cart cart = findById(idCart);
        //System.out.println(cart);
        for (ProductItem productItem : cart.getProductItemList()) {
            if (productItem.getProduct().equals(product)) {
                productItem.setQuantity(productItem.getQuantity()+1);
                return cartDAO.save(cart);
            }
        }
        ProductItem productItem = new ProductItem(cart, product, 1);


        List<ProductItem> productItemList = cart.getProductItemList();
        productItemList.add(productItem);
        cart.setProductItemList(productItemList);
        //cart.getProductItemList().add(productItem);
        return cartDAO.save(cart);
        //productItemDAO.save(productItem);       // Чего-то другое возвращать наверное надо
        //System.out.println("size: "+cart.getProductItemList().size());
        //System.out.println(productItem.getProduct());
        //return cart;
    }
}
