package com.example.Student.controller;

import com.example.Student.entity.Student;
import com.example.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.ok(studentService.save(student));
    }
    @PostMapping("/list")
    public List<Student> saveAllStudents(@RequestBody List<Student> students){
        return studentService.saveAllStudents(students);
    }
    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable long id){
        return ResponseEntity.ok(studentService.fineById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
        studentService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
