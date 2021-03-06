package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.UserDAO;
import com.epam.rd.onlinestore.entity.Privilege;
import com.epam.rd.onlinestore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

//    @Autowired
//    private UserService userService;

    @Autowired
    private UserDAO userDAO;


    @Override
    //@Transactional(readOnly=true)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        UserDetails loadedUser;
//
//        try {
//            User client = userDAO.findByUsername(username);
//            loadedUser = new org.springframework.security.core.userdetails.User(
//                    client.getUsername(), client.getPasswordHash(),
//                    client.getPrivileges());
//        } catch (Exception repositoryProblem) {
//            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
//        }
//
//        return loadedUser;

        User user = userDAO.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }


        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Privilege role : user.getPrivileges()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

//        return new org.springframework.security.core.userdetails.User(user.getUsername(),
//                user.getPassword(),
//                mapRolesToAuthorities(user.getPrivileges()));

        return user;



//    }


//        User user = userDAO.findByUsername(username);
//
////        Set<Privilege> privileges = userDAO.getUserRolesByUserId(user.getId());
////        System.out.println("privileges.size = "+privileges.size());
//
//
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Privilege role : user.getPrivileges()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//            System.out.println(role.getName());
//        }
//        System.out.println("КОЛИЧЕСТВО: "+user.getPrivileges().size());



////        User user = userService.findByUsername(username);
////        if (user == null) {
////            throw new UsernameNotFoundException(username);
////        }
////        return new MyUserPrincipal(user);
//
//
//        User user = userDAO.findByUsername(username);
//        if (user == null){
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//
////        return new org.springframework.security.core.userdetails.User(user.getEmail(),
////                user.getPassword(),
////                mapRolesToAuthorities(user.getRoles()));
//
//        return new MyUserPrincipal(user);

        //return user;
    }


//    private Set<? extends GrantedAuthority> mapRolesToAuthorities(Set<Privilege> roles){
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toSet());
//    }



}
