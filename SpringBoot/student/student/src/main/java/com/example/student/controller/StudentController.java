package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.exception.StudentIdNotFoundException;
import com.example.student.exception.StudentNameNotFoundException;
import com.example.student.response.StudentResponse;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping("/read/{id}")
    public Student readStudent(@PathVariable int id)throws StudentIdNotFoundException {
        return studentService.readStudent(id);
    }
    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student ){
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam int id){
        return studentService.deleteStudent(id);
    }
    @GetMapping("/find/{name}")
    public ResponseEntity<StudentResponse<Optional<Student>>> findByName(@PathVariable String name) throws StudentNameNotFoundException{
        Optional<Student> student=studentService.findByName(name);
        StudentResponse<Optional<Student>> studentResponse=new StudentResponse<>("Found", LocalDateTime.now(), student, HttpStatus.OK.value());
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }
}
