package com.example.actionservice.service;

import com.example.actionservice.entity.Student;
import com.example.actionservice.repo.StudentQueryService;
import com.example.actionservice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentQueryService queryClientService;

    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    // Update Dept By ID
    public Student updateByID(int id, String dept){
        Student student = queryClientService.readStudent(id);

        if (student != null){
            student.setStudentDepartment(dept);
            studentRepo.save(student);
            return student;
        }
        throw  new RuntimeException("Not Found");
    }
}