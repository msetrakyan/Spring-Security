package com.example.security.configuration;

import com.example.security.entity.roles.RoleEntity;
import com.example.security.repository.RoleRepository;
import com.example.security.repository.UserRepository;
import com.example.security.roles.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class InitConfig {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        createRoles();
    }



    private void createRoles() {
        if (!roleRepository.existsByRole(Role.ADMIN)) {
            RoleEntity admin = new RoleEntity();
            admin.setRole(Role.ADMIN);
            roleRepository.save(admin);
        }

        if (!roleRepository.existsByRole(Role.USER)) {
            RoleEntity user = new RoleEntity();
            user.setRole(Role.USER);
            roleRepository.save(user);
        }
    }

}