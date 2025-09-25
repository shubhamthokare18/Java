package com.example.queryservice.service;

import com.example.queryservice.entity.Student;
import com.example.queryservice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student readStudent(Integer id){
        return studentRepo.findById(id).orElseThrow();
    }
}