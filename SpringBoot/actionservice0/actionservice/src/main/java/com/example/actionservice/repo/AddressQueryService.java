package com.example.actionservice.repo;

import com.example.actionservice.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "studentqueryservice", url = "localhost:8091/address")
public interface AddressQueryService {
    @GetMapping("read/{id}")
    Address readAddress(@PathVariable Integer id);
}
