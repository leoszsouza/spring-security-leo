package com.souza.springsecurityleo.repository;

import com.souza.springsecurityleo.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Person findByUsername(String username);
}
