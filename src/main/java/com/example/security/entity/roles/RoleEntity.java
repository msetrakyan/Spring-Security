package com.example.security.entity.roles;


import com.example.security.roles.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "roles")
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private Role role;


}
