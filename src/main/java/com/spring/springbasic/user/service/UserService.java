package com.spring.springbasic.user.service;

import com.spring.springbasic.user.model.domain.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getUsers();
}
