package com.example.student.repo;

import com.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findByName(String name);
}
