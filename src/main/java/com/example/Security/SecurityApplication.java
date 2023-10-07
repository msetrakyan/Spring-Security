package com.example.Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.Security.roles.Role.USER;

@SpringBootApplication
public class SecurityApplication {
	public static void main(String[] args) {

		SpringApplication.run(SecurityApplication.class, args);

	}
}
