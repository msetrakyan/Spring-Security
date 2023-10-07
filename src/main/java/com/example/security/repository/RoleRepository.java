package com.example.security.repository;

import com.example.security.entity.roles.RoleEntity;
import com.example.security.roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    Boolean existsByRole(Role role);



}
