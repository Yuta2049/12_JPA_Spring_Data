package com.epam.rd.onlinestore.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "user", schema = "onlinestorerd", catalog = "")
public class User extends AbstractPersistable<Long> implements Serializable, UserDetails {

//    @NotNull
//    @NotEmpty
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @NotNull
//    @NotEmpty
    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;

//    @NotNull
//    @NotEmpty
    @Column(name = "passwordhash", nullable = false, length = 60)
    private String passwordhash;

    //private String matchingPasswordhash;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordhash;
    }

    public void setPassword(String password) {
        this.passwordhash = new BCryptPasswordEncoder().encode(password);
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return privileges;
    }

    @Override
    public String getPassword() {
        return getPasswordHash();
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
