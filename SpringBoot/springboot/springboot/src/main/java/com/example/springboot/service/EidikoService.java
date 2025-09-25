package com.example.springboot.service;

import com.example.springboot.entity.Eidiko;
import com.example.springboot.exception.EmployeeNotFoundException;
import com.example.springboot.repo.EidikoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EidikoService {
    @Autowired
    public EidikoRepo eidikoRepo;

    //get
    public Eidiko getById(int empId){
        Eidiko eidiko;
        try {
            eidiko = eidikoRepo.findById(empId).orElseThrow(()->{
                throw new EmployeeNotFoundException("Employee Not Found");
            });
        }
        catch (EmployeeNotFoundException e){
            throw e;
        }
        return eidiko;
    }

    //post
    public Eidiko add(Eidiko eidiko){
        return eidikoRepo.save(eidiko);
    }
}
