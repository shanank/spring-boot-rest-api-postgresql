package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID uuid, Person person);

    default int insertPerson(Person person) {
        UUID personId = UUID.randomUUID();
        return insertPerson(personId, person);
    }

    List<Person> getAllPersons();

    Optional<Person> getPersonById(UUID uuid);

    int removePerson(UUID uuid);

    int updatePerson(UUID uuid, Person person);


}
