package com.example.Student.service;

import com.example.Student.entity.Student;
import com.example.Student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public Student save(Student student){
        return studentRepo.save(student);
    }
    public List<Student> saveAllStudents(List<Student> students){
        return studentRepo.saveAll(students);
    }

    public List<Student> findAll(){
        return studentRepo.findAll();
    }
    public Student fineById(long id){
        return studentRepo.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
    }
    public void deleteById(long id){
        if (!studentRepo.existsById(id)){
            throw new RuntimeException("Student not found");
        }
        studentRepo.deleteById(id);
    }
}
