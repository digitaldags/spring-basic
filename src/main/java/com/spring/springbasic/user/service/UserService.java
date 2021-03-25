package com.spring.springbasic.user.service;

import com.spring.springbasic.user.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity userEntity);

    List<UserEntity> getUsers();
}
