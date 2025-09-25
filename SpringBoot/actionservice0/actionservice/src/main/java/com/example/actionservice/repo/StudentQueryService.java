package com.example.actionservice.repo;

import com.example.actionservice.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "addressqueryservice", url = "localhost:8091/student")
public interface StudentQueryService {

    @GetMapping("read/{id}")
    Student readStudent(@PathVariable Integer id);
}
