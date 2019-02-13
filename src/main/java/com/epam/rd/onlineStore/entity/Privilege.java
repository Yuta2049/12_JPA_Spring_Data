package com.epam.rd.onlinestore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role", schema = "onlinestorerd", catalog = "")
public class Privilege implements Serializable {

    @Id
    private long id;

    private String name;

//    @ManyToMany(cascade = CascadeType.ALL)
    //@ManyToMany
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "privileges")
    private Set<User> users;// = new HashSet<User>();


    public Privilege() {
    }

    public Privilege(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @ManyToMany(fetch = FetchType.EAGER, mappedBy="privileges")
    //@ManyToMany(mappedBy="privileges")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
