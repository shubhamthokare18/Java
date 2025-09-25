package com.example.actionservice.service;

import com.example.actionservice.entity.Address;
import com.example.actionservice.repo.AddressQueryService;
import com.example.actionservice.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private AddressQueryService addressQueryService;
    public Address saveAddress(Address address){
        return addressRepo.save(address);
    }
    public Address updateAddress(Integer id, String city){
        Address address = addressQueryService.readAddress(id);
        if (address!=null){
            address.setStudentCity(city);
            addressRepo.save(address);
            return address;
        }
        throw new RuntimeException("Not Found");
    }
}
