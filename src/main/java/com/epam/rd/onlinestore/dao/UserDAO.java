package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    List<User> findAll();

//    private List<User> userList = new ArrayList<>();
//
//    @PostConstruct
//    private void init() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//
//        Set<Privilege> privilegesUser = new HashSet<>();
//        privilegesUser.add(new Privilege(2, "ROLE_USER"));
//
//        Set<Privilege> privilegesAdmin = new HashSet<>();
//        privilegesAdmin.add(new Privilege(1, "ROLE_ADMIN"));
//
//        userList.add(new User(1, "admin", bCryptPasswordEncoder.encode("123"), privilegesAdmin));
//        //System.out.println(bCryptPasswordEncoder.encode("123")); $2a$10$1M1yW1bjZIgFRiWQ7S6Wsu1R20coZ44iR4xqO.Q8Ma4bHCBB5wuv.
//        userList.add(new User(2, "ivan", bCryptPasswordEncoder.encode("123"), privilegesUser));
//        userList.add(new User(3, "agafia", bCryptPasswordEncoder.encode("123"), privilegesUser));
//    }
//
//    public List<User> findAll() {
//        return userList;
//    }

    public User findByUsernameAndPasswordhash(String username, String password);

    public User findByUsername(String username);


//    public User findByUsernameAndPassword(String username, String password) {
//        return userList.stream().filter(o -> o.getUsername().equals(username) && o.getPassword().equals(password)).findFirst().orElse(null);
//    }
//
//
//    public User findUserByUsername(String username) {
//        return userList.stream().filter(o -> o.getUsername().equals(username)).findFirst().orElse(null);
//    }

}
