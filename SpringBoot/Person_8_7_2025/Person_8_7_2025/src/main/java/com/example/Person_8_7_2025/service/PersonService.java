package com.example.Person_8_7_2025.service;

import com.example.Person_8_7_2025.dto.PersonDto;
import com.example.Person_8_7_2025.entity.Person;
import com.example.Person_8_7_2025.exception.PersonNotFoundException;
import com.example.Person_8_7_2025.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public Person create(PersonDto personDto){
        ObjectMapper objectMapper=new ObjectMapper();
        Person person = objectMapper.convertValue(personDto, Person.class);
        return personRepository.save(person);
    }
    public String createAll(List<Person> person){
        personRepository.saveAll(person);
        return "createdAll";
    }
    public Person readById(int id){
        return personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException("person not found with " + id + " id"));
    }
    public List<Person> readAll(){
        return personRepository.findAll();
    }
    public String update(Person person){
        personRepository.save(person);
        return "updated";
    }
    public String updateAll(List<Person> person){
        personRepository.saveAll(person);
        return "updatedAll";
    }
    public String deleteById(int id){
        personRepository.deleteById(id);
        return "deleted";
    }
    public String deleteAll(){
        personRepository.deleteAll();
        return "deletedAll";
    }
}
