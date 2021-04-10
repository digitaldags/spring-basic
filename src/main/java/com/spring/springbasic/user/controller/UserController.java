package com.spring.springbasic.user.controller;

import com.spring.springbasic.user.model.domain.User;
import com.spring.springbasic.user.model.dto.request.UserRequestDto;
import com.spring.springbasic.user.model.dto.response.UserResponseDto;
import com.spring.springbasic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> saveSong(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.createUser(new User(userRequestDto.getName(), userRequestDto.getEmail(), userRequestDto.getMobileNumber())));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<User> userList = userService.getUsers();
        List<UserResponseDto> userResponseDto = new ArrayList<>();
        for (User user : userList) {
            userResponseDto.add(new UserResponseDto(user.getName(), user.getEmail(), user.getMobileNumber()));
        }
        return userResponseDto;
    }
}
