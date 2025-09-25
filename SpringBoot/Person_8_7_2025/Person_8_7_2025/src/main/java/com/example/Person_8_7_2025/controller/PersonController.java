package com.example.Person_8_7_2025.controller;

import com.example.Person_8_7_2025.dto.PersonDto;
import com.example.Person_8_7_2025.entity.Person;
import com.example.Person_8_7_2025.exception.PersonNotFoundException;
import com.example.Person_8_7_2025.response.PersonResponse;
import com.example.Person_8_7_2025.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @PostMapping
    public ResponseEntity<PersonResponse<Person>> create(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(new PersonResponse<>("person created", personService.create(personDto)));
    }
    @PostMapping("/createAll")
    public String createAll(@RequestBody List<Person> person){
        return personService.createAll(person);
    }
    @GetMapping("/{id}")
    public Person readById(@PathVariable int id) throws PersonNotFoundException {
        return personService.readById(id);
    }
    @GetMapping
    public List<Person> readAll(){
        return personService.readAll();
    }
    @PutMapping
    public String update(@RequestBody Person person){
        return personService.update(person);
    }
    @PutMapping("/updateAll")
    public String updateAll(@RequestBody List<Person> person){
        return personService.updateAll(person);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return personService.deleteById(id);
    }
    @DeleteMapping
    public String deleteAll(){
        return personService.deleteAll();
    }
}
