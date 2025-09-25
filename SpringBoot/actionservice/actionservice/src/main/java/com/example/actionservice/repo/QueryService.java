package com.example.actionservice.repo;

import com.example.actionservice.entity.Address;
import com.example.actionservice.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("QUERYSERVICE")
public interface QueryService {

    @GetMapping("student/read/{id}")
    Student readStudent(@PathVariable Integer id);

    @GetMapping("address/read/{id}")
    Address readAddress(@PathVariable Integer id);
}
