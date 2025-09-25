package com.example.Person.repo;

import com.example.Person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Integer> {
     Optional<Person> findByName(String name);
}
