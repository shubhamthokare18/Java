package com.example.actionservice.controller;

import com.example.actionservice.entity.Address;
import com.example.actionservice.service.AddressService;
import com.thoughtworks.xstream.io.AbstractDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping("save")
    public Address saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }
    @PostMapping("update")
    public Address updateAddress(@RequestParam Integer id, @RequestParam String city){
        return addressService.updateAddress(id, city);
    }
    @PostMapping("updateAddressByRt")
    public Address updateAddressByRt(@RequestParam int id, @RequestParam String city){
        return addressService.updateAddressByRt(id, city);
    }
}
