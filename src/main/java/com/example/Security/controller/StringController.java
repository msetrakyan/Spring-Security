package com.example.Security.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping(path = "/string")
public class StringController {


    @GetMapping(path = "/get")
    @RolesAllowed("ROLE_USER")
    public String get() {
        return "GET METHOD OF STRING CONTROLLER";
    }


    @PostMapping(path = "/post")
    @Secured("ROLE_ADMIN")
    public String post() {
        return "POST METHOD OF STRING CONTROLLER";
    }



}
