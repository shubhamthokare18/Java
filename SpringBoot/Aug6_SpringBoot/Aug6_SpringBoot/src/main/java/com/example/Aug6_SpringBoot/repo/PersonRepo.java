package com.example.Aug6_SpringBoot.repo;

import com.example.Aug6_SpringBoot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
}
