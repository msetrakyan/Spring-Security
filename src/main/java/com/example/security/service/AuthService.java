package com.example.security.service;

import com.example.security.entity.auth.AuthDto;
import com.example.security.entity.auth.AuthRequestDto;
import com.example.security.entity.user.UserCreateRequest;
import com.example.security.entity.user.UserEntity;

public interface AuthService {


    UserEntity register(UserCreateRequest userCreateRequest);

    AuthDto login(AuthRequestDto authRequestDto);




}
