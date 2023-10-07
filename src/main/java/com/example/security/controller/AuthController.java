package com.example.security.controller;


import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {



    @GetMapping(path = "/register")
    @PermitAll
    public String register() {
        return "REGISTER METHOD OF AUTH CONTROLLER";
    }



    @GetMapping(path = "/login")
    @PermitAll
    public String login() {
        return "LOGIN METHOD OF AUTH CONTROLLER";
    }












}
