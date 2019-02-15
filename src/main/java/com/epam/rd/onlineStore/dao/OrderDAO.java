package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

    List<Order> findAll();

    List<Order> findByUserId(long userId);

    Order save(Order order);
}
