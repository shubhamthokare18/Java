package com.example.Aug6_SpringBoot.service;

import com.example.Aug6_SpringBoot.entity.Person;
import com.example.Aug6_SpringBoot.repo.PersonRepo;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepo personRepo;
    public PersonService(PersonRepo personRepo){
        this.personRepo=personRepo;
    }
    public Person addPerson(Person person){
        return personRepo.save(person);
    }
//    public void setPersonRepo(PersonRepo personRepo){
//        this.personRepo=personRepo;
//    }
}
