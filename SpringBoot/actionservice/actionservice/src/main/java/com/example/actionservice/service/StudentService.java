package com.example.actionservice.service;

import com.example.actionservice.config.RestTemplateConfig;
import com.example.actionservice.entity.Student;
import com.example.actionservice.repo.QueryService;
import com.example.actionservice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private QueryService queryClientService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder builder;
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    // Update Dept By ID
    public Student updateByID(int id, String dept) {
        Student student = queryClientService.readStudent(id);

        if (student != null) {
            student.setStudentDepartment(dept);
            studentRepo.save(student);
            return student;
        }
        throw new RuntimeException("Not Found");
    }

    public Student updateByRt(int id, String dept) {


        String url = "http://localhost:8091/student/read/"+id;
        Student student = restTemplate.getForObject(url, Student.class);

        if (student != null) {
            student.setStudentDepartment(dept);
            studentRepo.save(student);
            return student;
        }
        throw new RuntimeException("Not Found");
    }

    public Student getByWc(int id){
        return builder.build()
                .get()
                .uri("http://QUERYSERVICE/student/read/{id}",id)
                .retrieve()
                .bodyToMono(Student.class)
                .block();
    }
}