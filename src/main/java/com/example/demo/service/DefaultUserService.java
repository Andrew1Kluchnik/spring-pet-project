package com.example.demo.service;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.Users;
import com.example.demo.exceptions.ValidationException;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultUserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    private void validateUserDao(UsersDao usersDao) throws
            ValidationException {
        if (Objects.isNull(usersDao)) {
            throw new ValidationException("Object user is null");
        }
        if (Objects.isNull(usersDao.getLogin()) ||
                usersDao.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }

    }

    public UsersDao saveUser(UsersDao usersDao) throws ValidationException {
        validateUserDao(usersDao);
        Users savedUsers = userRepository.save(userConverter.fromUserDaoToUser(usersDao));
        return userConverter.fromUserToUserDao(savedUsers);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public UsersDao findByLogin(String login) {
        Users users = userRepository.findByLogin(login);
        if (users != null) {
            return userConverter.fromUserToUserDao(users);
        }
        return null;
    }
    public List<UsersDao> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userConverter::fromUserToUserDao)
                .collect(Collectors.toList());

    }
}
