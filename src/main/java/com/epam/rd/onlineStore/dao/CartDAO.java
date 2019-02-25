package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.entity.Cart;
import com.epam.rd.onlinestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartDAO extends JpaRepository<Cart, Long> {

    Cart findByUserId(long userId);

    Cart findByUser(User user);

    Cart findById(long userId);

    //Cart save(long userId);
    Cart save(Cart cart);
}
