package com.example.security.repository;


import com.example.security.entity.user.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

    UserEntity findUserByUsername(String username);




}
