package com.souza.springsecurityleo.service;

import com.souza.springsecurityleo.entities.Person;
import com.souza.springsecurityleo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void savePerson(Person person){
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        personRepository.save(person);
    }

    public Person findByUsername(String username){
        return personRepository.findByUsername(username);
    }

    public Optional<Person> findById(Long id){
        return personRepository.findById(id);
    }
}
