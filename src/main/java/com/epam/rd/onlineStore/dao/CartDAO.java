package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartDAO  extends JpaRepository<Cart, Long> {

    Cart findByUserId(long userId);

}
