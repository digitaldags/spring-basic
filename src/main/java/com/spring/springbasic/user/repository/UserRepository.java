package com.spring.springbasic.user.repository;

import com.spring.springbasic.user.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE UserEntity set name = :name, email = :email, mobileNumber = :mobileNumber where id = :id")
    void update(
            @Param("name") String name,
            @Param("email") String email,
            @Param("mobileNumber") String mobileNumber,
            @Param("id") Long id
    );
}
