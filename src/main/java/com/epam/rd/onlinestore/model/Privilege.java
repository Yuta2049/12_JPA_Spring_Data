package com.epam.rd.onlinestore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role", schema = "onlinestorerd", catalog = "")
public class Privilege {

    @Id
    private long id;

    private String name;

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
