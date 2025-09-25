package com.example.springboot.controller;

import com.example.springboot.entity.Eidiko;
import com.example.springboot.response.ResponseHandler;
import com.example.springboot.service.EidikoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EidikoController {
    @Autowired
    private EidikoService eidikoService;

    @GetMapping("/get/{empId}")
    public Eidiko getById(@PathVariable int empId){
        return eidikoService.getById(empId);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseHandler> add(@RequestBody Eidiko eidiko){
        eidikoService.add(eidiko);
        ResponseHandler responseHandler = new ResponseHandler("Data Added" , HttpStatus.OK ,eidiko);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }
}
