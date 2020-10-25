package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgreSql")
public class DBPersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DBPersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID uuid, Person person) {
        final String insertQuery = "INSERT INTO person(id, name) VALUES(?,?)";
        return jdbcTemplate.update(insertQuery, uuid, person.getName());
    }

    @Override
    public List<Person> getAllPersons() {
        final String sqlQuery = "SELECT id, name FROM person";
        return jdbcTemplate.query(sqlQuery, new PersonMapper());
    }

    @Override
    public Optional<Person> getPersonById(UUID uuid) {
        final String queryById = "SELECT id, name FROM person WHERE id = ?";
        final Person person = (Person) jdbcTemplate.queryForObject(queryById, new Object[]{uuid}, new PersonMapper());
        return Optional.ofNullable(person);
    }

    @Override
    public int removePerson(UUID uuid) {
        final String deleteQuery = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(deleteQuery, uuid);
    }

    @Override
    public int updatePerson(UUID uuid, Person person) {
        final String updateQuery = "UPDATE person SET id= ?, name = ? WHERE id = ?";
        return jdbcTemplate.update(updateQuery, person.getPersonId(), person.getName(), uuid);
    }
}
