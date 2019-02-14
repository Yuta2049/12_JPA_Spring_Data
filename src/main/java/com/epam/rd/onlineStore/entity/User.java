package com.epam.rd.onlinestore.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "user", schema = "onlinestorerd", catalog = "")
public class User extends AbstractPersistable<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;

//    @Column(name = "\"passwordHash\"")
    @Column(name = "passwordhash", nullable = false, length = 60)
    private String passwordhash;

    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST})
    @JoinTable(name="users_roles", schema = "onlinestorerd", catalog = "",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
//        joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
//        inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="id"))
    private Set<Privilege> privileges;// = new HashSet<>();

    public User() {
    }

    public User(long id, String username, String passwordHash, Set<Privilege> privileges) {
        this.id = id;
        this.username = username;
        this.passwordhash = passwordhash;
        this.privileges = privileges;
    }

    public Long getId() {
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


//    //@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @ManyToMany
//    @JoinTable(name = "user_roles",
//            //foreign key for EmployeeEntity in employee_car table
//            //joinColumns = @JoinColumn(name = "employee_id"),
//            joinColumns = @JoinColumn(name = "user_id"),
//            //foreign key for other side - EmployeeEntity in employee_car table
//            //inverseJoinColumns = @JoinColumn(name = "car_id"))
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    @Transactional
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//@ManyToMany(cascade = CascadeType.ALL)
////    @JoinTable(name = "users_roles",
////            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
////            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
//@JoinTable(name = "users_roles",
//        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoinColumns = @JoinColumn(name = "role_id"))
//    @ManyToMany //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Privilege> getPrivileges() {
        return privileges;
    }

//    public void setPrivileges(Set<Privilege> privileges) {
//        this.privileges = privileges;
//    }
}
