package com.souza.springsecurityleo.controller;

import com.souza.springsecurityleo.entities.Person;
import com.souza.springsecurityleo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public void savePerson(@RequestBody PersonRequest personRequest){
        personService.savePerson(new Person(personRequest.getUsername(), personRequest.getPassword()));
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id){
        return ResponseEntity.of(personService.findById(id));
    }
}
