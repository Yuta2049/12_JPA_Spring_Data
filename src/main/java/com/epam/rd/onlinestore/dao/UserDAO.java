package com.epam.rd.onlinestore.dao;

import com.epam.rd.onlinestore.entity.Privilege;
import com.epam.rd.onlinestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User, Long> {

    @Query(value = "select u from User u left join fetch u.privileges p")
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


    //@Query("SELECT p FROM Person p JOIN FETCH p.roles WHERE p.id = (:id)")
//    @Query(value = "select distinct p from Person p left join fetch p.groups")
    //@Query("value = "SELECT u FROM user u JOIN FETCH u.roles WHERE p.id = (:id)")
   // @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.login = :login")
    //@Query(value = "select u from User u left join fetch u.role where u.username = :username and u.passwordhash = :passwordhash")

    public User findByUsernameAndPasswordhash(@Param("username") String username, @Param("passwordhash") String password);

    public User findByUsername(String username);

    public User save(User user);

    //public User findOne(long id);



    //@Query(value = "select u from user u left join fetch u.roles where u.id = :id")
    //@Query(value = "select u from User u where u.id = (:id)")
    //@Query(value = "select u from User u left join fetch u.privileges p where u.id = (:id)")
    //@Query(value = "select u from User u left join fetch u.privileges p where u.id = (:id)")
    //@Query(value = "select u from User u left join fetch u.privileges p where u.id = (:id)")
    @Query(value = "select u from User u left join fetch u.privileges p where u.id = (:id)")
    public User findById(@Param("id") long id); //where t.supervisor = e.name
    //public User findById(long id);




    //@Query("SELECT u.roles FROM User u WHERE u.id = :id")
//    public Set<Privilege> getUserRolesByUserId(@Param("id") long id);
    //public Set<Privilege> getUserRolesByUserId(@Param("id") long id);



//    public User findByUsernameAndPassword(String username, String password) {
//        return userList.stream().filter(o -> o.getUsername().equals(username) && o.getPassword().equals(password)).findFirst().orElse(null);
//    }
//
//
//    public User findUserByUsername(String username) {
//        return userList.stream().filter(o -> o.getUsername().equals(username)).findFirst().orElse(null);
//    }

}
