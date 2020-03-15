package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody @NotNull @Valid Person person) {

        int value = personService.addPerson(person);
        if(value == 1) {
            LOGGER.info("Person added !!!");
        }
    }

    @GetMapping
    public List<Person> getAllPerson() {
        LOGGER.info("Retrieving all Persons !!!");
        return personService.getAllPerson();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable ("id") UUID id) {
        LOGGER.info("Retrieving Person By Id !!!");
        return personService.getPersonById(id);
    }

    @DeleteMapping(path = "{id}")
    public int removePerson(@PathVariable ("id") UUID id) {
        LOGGER.info("Deleting Person By Id !!!");
        return personService.removePerson(id);
    }

    @PutMapping(path = "{id}")
    public int updatePerson(@PathVariable ("id") UUID id,
                            @RequestBody Person person) {
        LOGGER.info("Updating Person By Id !!!");
        return personService.updatePerson(id, person);
    }
}
