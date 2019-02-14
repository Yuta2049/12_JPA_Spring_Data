package com.epam.rd.onlinestore.entity;

import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserPrincipal implements UserDetails {

    private User user;

    public MyUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        System.out.println("Мы в UserPrincipal");
        //Hibernate.initialize(user.getPrivileges());
        //JpaUtils.initialize(em, entity, depth);
        System.out.println("user.getPrivileges()) "+ user.getPrivileges().size());

//      for (Privilege privilege : user.getPrivileges()) {
          for (Privilege privilege : user.getPrivileges()) {
            authorities.add(new SimpleGrantedAuthority(privilege.getName()));
              System.out.println("Vtoroy cirl");
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
