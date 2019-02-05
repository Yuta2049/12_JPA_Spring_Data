package com.epam.rd.onlinestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDAO extends JpaRepository<com.epam.rd.onlinestore.entity.Privilege, Long> {

    List<com.epam.rd.onlinestore.entity.Privilege> findAll();

}
