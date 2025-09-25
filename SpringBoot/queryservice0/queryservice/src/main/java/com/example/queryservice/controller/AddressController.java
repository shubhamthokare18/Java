package com.example.queryservice.controller;

import com.example.queryservice.entity.Address;
import com.example.queryservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("read/{id}")
    public Optional<Address> readAddress(@PathVariable Integer id){
        return addressService.readAddress(id);
    }
}
