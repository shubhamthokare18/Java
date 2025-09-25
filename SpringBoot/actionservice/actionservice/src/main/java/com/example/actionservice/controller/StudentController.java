package com.example.actionservice.controller;

import com.example.actionservice.entity.Student;
import com.example.actionservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("save")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    // Update Dept By Id
    @PostMapping("updateByID")
    public ResponseEntity<Student> updateByID(@RequestParam int id , @RequestParam String dept){
        Student student = studentService.updateByID(id, dept);
        return ResponseEntity.ok(student);
    }
    @PostMapping("updateByRt")
    public Student updateByRt(@RequestParam int id, @RequestParam String dept){
        return studentService.updateByRt(id, dept);
    }
    @GetMapping("getByWc/{id}")
    public Student getByWc(@PathVariable int id){
        return studentService.getByWc(id);
    }
}
