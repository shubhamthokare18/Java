package com.example.Person.service;

import com.example.Person.entity.Person;
import com.example.Person.exception.PersonIdNotFoundException;
import com.example.Person.exception.PersonNameNotFoundException;
import com.example.Person.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;
    public String createPerson(Person person){
        personRepo.save(person);
        return "created";
    }
    public Person readPerson(int id) throws PersonIdNotFoundException{
        return personRepo.findById(id).orElseThrow(()->{throw new PersonIdNotFoundException("Person ID Not Found");});
    }
    public String updatePerson(Person person){
        personRepo.save(person);
        return "updated";
    }
    public String deletePerson(int id){
        personRepo.deleteById(id);
        return "deleted";
    }
    public Optional<Person> findByName(String name) throws PersonNameNotFoundException{
        Optional<Person> person = personRepo.findByName(name);
        if (person.isEmpty()){
            throw  new PersonNameNotFoundException("Person Name Not Found");
        }else{
            return personRepo.findByName(name);
        }
    }
}
