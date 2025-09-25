package com.example.hibernatevalidation.repo;

import com.example.hibernatevalidation.entity.UserName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserRepository extends JpaRepository<UserName, Integer> {
}
