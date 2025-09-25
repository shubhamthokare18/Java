package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.exception.StudentIdNotFoundException;
import com.example.student.exception.StudentNameNotFoundException;
import com.example.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public String createStudent(Student student){
        studentRepo.save(student);
        return "created";
    }
    public Student readStudent(int id){
        return studentRepo.findById(id).orElseThrow(()->{
            throw new StudentIdNotFoundException("Student Id Not Found");
        });
    }
    public String updateStudent(Student student){
        studentRepo.save(student);
        return "updated";
    }
    public String deleteStudent(int id){
        studentRepo.deleteById(id);
        return "deleted";
    }
    public Optional<Student> findByName(String name) throws StudentNameNotFoundException{
        Optional<Student> student = studentRepo.findByName(name);
        if (student.isEmpty()){
            throw new StudentNameNotFoundException("Student Not Found");
        }else {
            return student;
        }
    }
}
