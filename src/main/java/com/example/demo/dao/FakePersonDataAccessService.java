package com.example.demo.dao;


import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> dbPersonList = new ArrayList<>();

    @Override
    public int insertPerson(UUID uuid, Person person) {

        dbPersonList.add(new Person(uuid,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPersons() {
        return dbPersonList;
    }

    @Override
    public Optional<Person> getPersonById(UUID uuid) {

         return dbPersonList.stream()
                .filter(person -> person.getPersonId() != null &&  person.getPersonId().equals(uuid))
                .findFirst();
    }

    @Override
    public int removePerson(UUID uuid) {

        int index = dbPersonList.stream()
                .map(Person::getPersonId)
                .collect(Collectors.toList())
                .indexOf(uuid);

        if(index >= 0) {
            dbPersonList.remove(index);
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePerson(UUID uuid, Person person) {

        int index = dbPersonList.stream()
                .map(Person::getPersonId)
                .collect(Collectors.toList())
                .indexOf(uuid);
        if(index >= 0) {
            dbPersonList.remove(index);
            dbPersonList.add(index, new Person(uuid, person.getName()));
            return 1;
        }
        return 0;
    }

}
