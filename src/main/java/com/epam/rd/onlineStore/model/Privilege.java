package com.epam.rd.onlineStore.model;

import org.springframework.security.core.GrantedAuthority;

public class Privilege {

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
