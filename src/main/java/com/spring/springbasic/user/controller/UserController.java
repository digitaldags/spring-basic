package com.spring.springbasic.user.controller;

import com.spring.springbasic.user.model.domain.User;
import com.spring.springbasic.user.model.dto.request.UserRequestDto;
import com.spring.springbasic.user.model.dto.response.UserResponseDto;
import com.spring.springbasic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<?> save(@RequestBody UserRequestDto userRequestDto) {
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

    @GetMapping(value = "{id}")
    public UserResponseDto get(@PathVariable Long id) {
        User user = userService.getUser(id);
        return new UserResponseDto(user.getName(), user.getEmail(), user.getMobileNumber());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        userService.updateUser(id, new User(userRequestDto.getName(), userRequestDto.getEmail(), userRequestDto.getMobileNumber()));
        return ResponseEntity.ok("User updated.");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted.");
    }
}
