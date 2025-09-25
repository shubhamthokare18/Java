package com.example.queryservice.service;

import com.example.queryservice.entity.Address;
import com.example.queryservice.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    public Optional<Address> readAddress(Integer id){
        return addressRepo.findById(id);
    }
}
