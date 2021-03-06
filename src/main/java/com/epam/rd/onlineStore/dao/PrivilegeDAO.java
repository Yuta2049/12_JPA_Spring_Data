package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeDAO extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

}
