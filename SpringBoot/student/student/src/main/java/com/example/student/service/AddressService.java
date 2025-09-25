package com.example.student.service;

import com.example.student.entity.Address;
import com.example.student.entity.Student;
import com.example.student.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    public String createAddress(Address address){
        addressRepo.save(address);
        return "created";
    }
    public Address readAddress(int pincode){
        return addressRepo.findById(pincode).orElseThrow(()->{
            throw new RuntimeException();
        });
    }
    public String updateAddress(Address address){
        addressRepo.save(address);
        return "updated";
    }
    public String deleteAddress(int pincode){
        addressRepo.deleteById(pincode);
        return "deleted";
    }
}
