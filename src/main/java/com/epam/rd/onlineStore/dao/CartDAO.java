package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartDAO  extends JpaRepository<Cart, Long> {

    Cart findByUserId(long userId);

    Cart findById(long userId);

}
