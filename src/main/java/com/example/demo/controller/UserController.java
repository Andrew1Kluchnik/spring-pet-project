package com.example.demo.controller;

import com.example.demo.dao.UsersDao;
import com.example.demo.exceptions.ValidationException;
import com.example.demo.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
@CrossOrigin
public class UserController {
    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDao saveUsers(@RequestBody UsersDao usersDao) throws ValidationException
    {
        log.info("Handling save users: " + usersDao);
        return usersService.saveUser(usersDao);
    }
    @GetMapping("/findAll")
    public List<UsersDao> findAllUsers(){
        log.info("Handling find all users request");
        return usersService.findAllUsers();
    }
    @GetMapping("/findByLogin")
    public UsersDao findByLogin(@RequestParam String login){
        log.info("Handling find by login request: " + login);
        return usersService.findByLogin(login);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id){
        log.info("Handling delete user request: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
