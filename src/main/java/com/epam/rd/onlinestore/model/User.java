package com.epam.rd.onlinestore.model;


import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    private long id;

    private String username;

//    @Column(name = "\"passwordHash\"")
    @Column(name = "passwordhash")
    private String passwordhash;

    @ElementCollection(targetClass=Privilege.class)
    private Set<Privilege> privileges = new HashSet<>();

    public User() {
    }

    public User(long id, String username, String passwordHash, Set<Privilege> privileges) {
        this.id = id;
        this.username = username;
        this.passwordhash = passwordhash;
        this.privileges = privileges;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordhash;
    }

    public void setPassword(String password) {
        this.passwordhash = password;
    }


    //@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(name = "user_roles",
            //foreign key for EmployeeEntity in employee_car table
            //joinColumns = @JoinColumn(name = "employee_id"),
            joinColumns = @JoinColumn(name = "user_id"),
            //foreign key for other side - EmployeeEntity in employee_car table
            //inverseJoinColumns = @JoinColumn(name = "car_id"))
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Transactional
    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }
}
