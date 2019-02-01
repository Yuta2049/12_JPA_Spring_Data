package com.epam.rd.onlinestore.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    private long id;

    private String username;

    @Column(name = "passwordHash")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userRoles",
            //foreign key for EmployeeEntity in employee_car table
            //joinColumns = @JoinColumn(name = "employee_id"),
            joinColumns = @JoinColumn(name = "user_id"),
            //foreign key for other side - EmployeeEntity in employee_car table
            //inverseJoinColumns = @JoinColumn(name = "car_id"))
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Privilege> privileges;

    public User() {
    }

    public User(long id, String username, String password, Set<Privilege> privileges) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }
}
