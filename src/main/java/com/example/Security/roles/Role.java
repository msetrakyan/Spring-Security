package com.example.Security.roles;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Role {

    USER("USER"),
    ADMIN("ADMIN");

    private final String name;

    Role(String name) {
        this.name = name;
    }


}
