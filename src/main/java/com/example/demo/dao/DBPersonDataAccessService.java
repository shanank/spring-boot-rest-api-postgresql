package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PostgreSQL")
public class DBPersonDataAccessService implements PersonDao {
    @Override
    public int insertPerson(UUID uuid, Person person) {
        return 0;
    }

    @Override
    public int insertPerson(Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPersons() {
        UUID personId = UUID.randomUUID();
        return Arrays.asList(new Person(personId, "postGressDBName"));
    }

    @Override
    public Optional<Person> getPersonById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public int removePerson(UUID uuid) {
        return 0;
    }

    @Override
    public int updatePerson(UUID uuid, Person person) {
        return 0;
    }
}
