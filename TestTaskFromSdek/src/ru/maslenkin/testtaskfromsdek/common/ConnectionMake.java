package ru.maslenkin.testtaskfromsdek.common;

import ru.maslenkin.testtaskfromsdek.model.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ConnectionMake {
    Connection connect() throws SQLException;

    void addPerson(String name) throws ClassNotFoundException, SQLException;

    ArrayList<Person> getPerson() throws SQLException;

    ArrayList<Person> getFilterDatabase(int id, String name) throws SQLException;
}
