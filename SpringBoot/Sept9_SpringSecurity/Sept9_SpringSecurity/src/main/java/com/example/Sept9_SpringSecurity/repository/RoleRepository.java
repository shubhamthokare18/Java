package com.example.Sept9_SpringSecurity.repository;

import com.example.Sept9_SpringSecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(String name);
}
