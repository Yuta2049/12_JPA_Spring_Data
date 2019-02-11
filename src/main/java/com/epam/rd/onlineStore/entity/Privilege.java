package com.epam.rd.onlinestore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role", schema = "onlinestorerd", catalog = "")
public class Privilege {

    @Id
    private long id;

    private String name;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
//    private Set<User> users;// = new HashSet<>();


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
}
