package com.epam.rd.onlinestore.service;

import com.epam.rd.onlinestore.entity.ClientOrder;

import java.util.List;

public interface OrderService {

    public List<ClientOrder> findAll();

    public ClientOrder save();

}
