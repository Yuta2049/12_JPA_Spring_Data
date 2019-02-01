package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDAO extends JpaRepository<Privilege, Long> {

    List<Privilege> findAll();

}
