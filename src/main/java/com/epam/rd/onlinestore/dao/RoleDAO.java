package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDAO extends JpaRepository<Role, Long> {

    List<Role> findAll();

}
