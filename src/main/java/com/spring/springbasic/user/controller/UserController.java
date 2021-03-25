package com.spring.springbasic.user.controller;

import com.spring.springbasic.user.entity.UserEntity;
import com.spring.springbasic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> saveSong(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.createUser(userEntity));
    }

    @GetMapping
    public List<UserEntity> getAll() {
        return userService.getUsers();
    }
}
