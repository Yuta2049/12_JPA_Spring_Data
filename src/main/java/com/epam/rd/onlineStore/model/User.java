package com.epam.rd.onlineStore.model;

import java.util.*;


public class User {

    private long id;
    private String username;
    private String password;

    private Set<Privilege> privileges;

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
