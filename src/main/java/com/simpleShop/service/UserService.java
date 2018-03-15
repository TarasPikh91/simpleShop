package com.simpleShop.service;

import com.simpleShop.entity.User;

import java.util.List;

public interface UserService {

    void save(User user) throws Exception;

    void delete(int id);

    User findOne(int id);

    List<User> findAll();
}
