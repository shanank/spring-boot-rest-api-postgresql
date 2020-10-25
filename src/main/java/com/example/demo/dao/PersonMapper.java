package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PersonMapper implements RowMapper {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        final UUID personId = UUID.fromString(resultSet.getString("id"));
        final String personName = resultSet.getString("name");
        return new Person(personId, personName);
    }
}
