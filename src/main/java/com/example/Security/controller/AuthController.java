package com.example.Security.controller;


import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {



    @PostMapping(path = "/register")
    @PermitAll
    public String register() {
        return "REGISTER METHOD OF AUTH CONTROLLER";
    }



    @PostMapping(path = "/login")
    @PermitAll
    public String login() {
        return "LOGIN METHOD OF AUTH CONTROLLER";
    }












}
