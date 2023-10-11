package com.example.security.service.impl;

import com.example.security.entity.auth.AuthDto;
import com.example.security.entity.auth.AuthRequestDto;
import com.example.security.entity.roles.RoleEntity;
import com.example.security.entity.user.UserCreateRequest;
import com.example.security.entity.user.UserEntity;
import com.example.security.jwt.JwtTokenProvider;
import com.example.security.repository.RoleRepository;
import com.example.security.repository.UserRepository;
import com.example.security.roles.Role;
import com.example.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity register(UserCreateRequest userCreateRequest) {
        UserEntity user = new UserEntity();

        RoleEntity role = roleRepository.findById(1).get();

        user.setId(null);
        user.setUsername(userCreateRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        user.setRole(role);

        userRepository.save(user);

        return user;
    }


    @Override
    public AuthDto login(AuthRequestDto authRequestDto) {

        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getLogin(), authRequestDto.getPassword()));

        UserEntity user = userRepository.findUserByUsername(authRequestDto.getLogin());

        Integer id = user.getId();

        String accessToken = jwtTokenProvider.generateAccessToken(id, user.getUsername(), user.getRole().getRole().getName());

        return new AuthDto(accessToken);
    }





}
