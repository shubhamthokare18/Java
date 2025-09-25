package com.ashar.profileManager.controller;

import com.ashar.profileManager.entity.User;
import com.ashar.profileManager.service.Response;
import com.ashar.profileManager.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-manager")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Response<User>> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/user/all")
    public ResponseEntity<Response<List<User>>> addAllUsers(@RequestBody List<User> users) {
        return userService.addAllUsers(users);
    }

    @GetMapping("/user/all")
    public ResponseEntity<Response<List<User>>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Response<User>> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/name/{name}")
    public ResponseEntity<Response<User>> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Response<User>> updateUserById(@PathVariable int id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Response<User>> deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

}
