package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.entity.CartProductItem;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemDAO extends JpaRepository<CartProductItem, ObjectIdGenerator.IdKey> {

    CartProductItem save(CartProductItem cartProductItem);

}
