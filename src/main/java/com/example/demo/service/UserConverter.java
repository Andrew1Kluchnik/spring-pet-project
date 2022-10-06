package com.example.demo.service;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public Users fromUserDaoToUser(UsersDao usersDao){
        Users users =  new Users();
        users.setId(usersDao.getId());
        users.setEmail(usersDao.getEmail());
        users.setLogin(usersDao.getLogin());
        users.setName(usersDao.getName());
        return users;
    }
    public UsersDao fromUserToUserDao(Users users){
        return UsersDao.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .build();
    }
}
