package com.example.queryservice.controller;

import com.example.queryservice.entity.Student;
import com.example.queryservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/read/{id}")
    public Student readStudent(@PathVariable Integer id){
        return studentService.readStudent(id);
    }
}
