package com.example.springsecurity.repository;

import com.example.springsecurity.entity.BlogUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<BlogUsers, Integer> {

    BlogUsers findByUserName(String username);
}