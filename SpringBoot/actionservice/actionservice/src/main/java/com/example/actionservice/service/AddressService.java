package com.example.actionservice.service;

import com.example.actionservice.entity.Address;
import com.example.actionservice.repo.AddressRepo;
import com.example.actionservice.repo.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private QueryService addressQueryService;
    @Autowired
    private RestTemplate restTemplate;
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
    public Address updateAddressByRt(int id, String city){
        String url="http://localhost:8091/address/read/"+id;
        Address address=restTemplate.getForObject(url, Address.class);
        if (address!=null){
            address.setStudentCity(city);
            addressRepo.save(address);
            return address;
        }
        throw new RuntimeException("Not Found");
    }
}
