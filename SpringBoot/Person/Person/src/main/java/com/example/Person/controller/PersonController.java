package com.example.Person.controller;

import com.example.Person.entity.Person;
import com.example.Person.exception.PersonIdNotFoundException;
import com.example.Person.exception.PersonNameNotFoundException;
import com.example.Person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;
    @PostMapping("/create")
    public String createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
    @GetMapping("/read/{id}")
    public Person findById(@PathVariable int id) throws PersonIdNotFoundException {
        return personService.readPerson(id);
    }

    @PutMapping("/update")
    public String updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }
    @DeleteMapping("/delete")
    public String deletePerson(@RequestParam int id){
        return personService.deletePerson(id);
    }
    @GetMapping("/find/{name}")
    public Optional<Person> findByName(@PathVariable String name) throws PersonNameNotFoundException {
        return personService.findByName(name);
    }
}
