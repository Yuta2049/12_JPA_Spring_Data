package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<ClientOrder, Long> {

    List<ClientOrder> findAll();

    List<ClientOrder> findByUserId(long userId);

    ClientOrder save(ClientOrder clientOrder);
}
