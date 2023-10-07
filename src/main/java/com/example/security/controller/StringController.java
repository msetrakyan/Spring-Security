package com.example.security.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping(path = "/string")
public class StringController {


    @GetMapping(path = "/getForUser")
    @PreAuthorize("hasAuthority('USER')")
    public String get() {
        return "GET METHOD OF STRING CONTROLLER FOR USER";
    }


    @GetMapping(path = "/getForAdmin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String post() {
        return "GET METHOD OF STRING CONTROLLER FOR ADMIN";
    }


}
