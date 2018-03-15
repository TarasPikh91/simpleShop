package com.simpleShop.dao;


import com.simpleShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByName(String name);
    User findByEmail(String email);
    User findByPassword(String password);
}
