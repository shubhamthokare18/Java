package com.example.Aug6_SpringBoot.controller;

import com.example.Aug6_SpringBoot.entity.Person;
import com.example.Aug6_SpringBoot.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private PersonService personService;
    public PersonController(PersonService personService){
        this.personService=personService;
    }
    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
}
