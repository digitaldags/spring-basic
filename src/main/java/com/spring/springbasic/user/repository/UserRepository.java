package com.spring.springbasic.user.repository;

import com.spring.springbasic.user.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}