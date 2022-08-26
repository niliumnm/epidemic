package com.cdut.service;

import com.cdut.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User findByName(String username);

    int register(User user);
    int update(User user);

    User getUserByID(int id);

    Integer deleteByID(Integer id);

}
