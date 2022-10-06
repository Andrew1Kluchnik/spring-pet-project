package com.example.demo.service;


import com.example.demo.dao.UsersDao;

import java.util.List;

public interface UsersService {
    UsersDao saveUser(UsersDao usersDao);

    void deleteUser(Integer userId);

    UsersDao findByLogin(String login);

    List<UsersDao> findAll();
}
