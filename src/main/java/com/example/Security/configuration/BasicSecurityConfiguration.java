package com.example.Security.configuration;


import com.example.Security.roles.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.Security.roles.Role.ADMIN;
import static com.example.Security.roles.Role.USER;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class BasicSecurityConfiguration {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/auth/register").permitAll()
//                .antMatchers("/auth/login").permitAll()
//                .antMatchers("/string/get").hasRole(USER.getName())
//                .antMatchers("/string/post").hasRole(ADMIN.getName())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    return http.getOrBuild();
    }


    @Bean
    UserDetailsService userDetailsService() {

        UserDetails build = User.builder()
                .username("anna")
                .password(passwordEncoder().encode("password"))
                .roles(USER.getName()) //ROLE_USER
                .build();

        UserDetails build2 = User.builder()
                .username("linda")
                .password(passwordEncoder().encode("password"))
                .roles(ADMIN.getName()) //ROLE_ADMIN
                .build();

        return new InMemoryUserDetailsManager(build, build2);
    }








}
