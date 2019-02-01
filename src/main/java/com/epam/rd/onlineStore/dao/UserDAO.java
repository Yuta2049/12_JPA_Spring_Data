package com.epam.rd.onlineStore.dao;

import com.epam.rd.onlineStore.model.Privilege;
import com.epam.rd.onlineStore.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDAO {

    private List<User> userList = new ArrayList<>();

    @PostConstruct
    private void init() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        Set<Privilege> privilegesUser = new HashSet<>();
        privilegesUser.add(new Privilege(2, "ROLE_USER"));

        Set<Privilege> privilegesAdmin = new HashSet<>();
        privilegesAdmin.add(new Privilege(1, "ROLE_ADMIN"));

        userList.add(new User(1, "admin", bCryptPasswordEncoder.encode("123"), privilegesAdmin));
        userList.add(new User(2, "ivan", bCryptPasswordEncoder.encode("123"), privilegesUser));
        userList.add(new User(3, "agafia", bCryptPasswordEncoder.encode("123"), privilegesUser));
    }

    public List<User> findAll() {
        return userList;
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userList.stream().filter(o -> o.getUsername().equals(username) && o.getPassword().equals(password)).findFirst().orElse(null);
    }


    public User findUserByUsername(String username) {
        return userList.stream().filter(o -> o.getUsername().equals(username)).findFirst().orElse(null);
    }

}
