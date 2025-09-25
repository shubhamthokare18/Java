package com.example.student.controller;

import com.example.student.entity.Address;
import com.example.student.entity.Student;
import com.example.student.service.AddressService;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping("/create")
    public String createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }
    @GetMapping("/read/{pincode}")
    public Address readAddress(@PathVariable int pincode){
        return addressService.readAddress(pincode);
    }
    @PutMapping("/update")
    public String updateAddress(@RequestBody Address address ){
        return addressService.updateAddress(address);
    }
    @DeleteMapping("/delete")
    public String deleteAddress(@RequestParam int pincode){
        return addressService.deleteAddress(pincode);
    }
}
