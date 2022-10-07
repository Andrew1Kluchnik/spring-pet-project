package com.example.demo.service;


import com.example.demo.dao.UsersDao;
import com.example.demo.exceptions.ValidationException;

import java.util.List;
public interface UsersService {
    UsersDao saveUser(UsersDao usersDao) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDao findByLogin(String login);

    List<UsersDao> findAllUsers();
}
