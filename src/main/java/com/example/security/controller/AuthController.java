package com.example.security.controller;


import com.example.security.entity.auth.AuthDto;
import com.example.security.entity.auth.AuthRequestDto;
import com.example.security.entity.user.UserCreateRequest;
import com.example.security.entity.user.UserEntity;
import com.example.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;


    @PostMapping(path = "/register")
    @PreAuthorize("permitAll()")
    public UserEntity register(@RequestBody UserCreateRequest userCreateRequest) {
        return authService.register(userCreateRequest);
    }



    @PostMapping(path = "/login")
    @PreAuthorize("permitAll()")
    public AuthDto login(@RequestBody AuthRequestDto authRequestDto) {

        return authService.login(authRequestDto);
    }












}
