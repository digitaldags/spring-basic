package com.spring.springbasic.user.service;

import com.spring.springbasic.user.model.domain.User;
import com.spring.springbasic.user.model.entity.UserEntity;
import com.spring.springbasic.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userRepository.save(new UserEntity(null, user.getName(), user.getEmail(), user.getMobileNumber()));
        return new User(userEntity.getName(), user.getEmail(), user.getMobileNumber());
    }

    @Override
    public List<User> getUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            userList.add(new User(userEntity.getName(), userEntity.getEmail(), userEntity.getMobileNumber()));
        }
        return userList;
    }
}
