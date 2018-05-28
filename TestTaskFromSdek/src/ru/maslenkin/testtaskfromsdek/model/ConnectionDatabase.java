package ru.maslenkin.testtaskfromsdek.model;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import ru.maslenkin.testtaskfromsdek.common.ConnectionMake;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionDatabase implements ConnectionMake {
    private static final String URL = "jdbc:mysql://localhost:3306/person";
    private static final String CLASS_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    @Override
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void addPerson(String name) throws ClassNotFoundException, SQLException {
        Class.forName(CLASS_DRIVER);
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("USE person");
            try {
                statement.executeUpdate("INSERT INTO person(name) VALUES('" + name + "');");
            } catch (MySQLSyntaxErrorException e) {
                statement.executeUpdate("CREATE TABLE person (id INT AUTO_INCREMENT primary KEY, name VARCHAR(255) NOT NULL );");
            }
        }
    }

    @Override
    public ArrayList<Person> getPerson() throws SQLException {
        ArrayList<Person> data = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("USE person;");
            try {
                resultSet = statement.executeQuery("SELECT * FROM person;");
            } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
                statement.executeUpdate("CREATE TABLE person (id INT AUTO_INCREMENT primary KEY, name VARCHAR(255) NOT NULL );");
                resultSet = statement.executeQuery("SELECT * FROM person;");
            }
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String string = resultSet.getString("name");
                Person object = new Person(id, string);
                data.add(object);
            }
        }
        return data;
    }

    @Override
    public ArrayList<Person> getFilterDatabase(int id, String name) throws SQLException {
        ArrayList<Person> arrayListPerson = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            if (id == 0 && name.length() != 0) {
                String query = "SELECT name , id FROM person WHERE name = '" + name + "';";
                resultSet = statement.executeQuery(query);
            } else if (id != 0 && name.length() == 0) {
                String query = "SELECT name , id FROM person WHERE id = '" + id + "';";
                resultSet = statement.executeQuery(query);
            } else {
                resultSet = statement.executeQuery("SELECT * FROM person;");
            }
            while (resultSet.next()) {
                int idResult = resultSet.getInt("id");
                String string = resultSet.getString("name");
                Person object = new Person(idResult, string);
                arrayListPerson.add(object);
            }
        }
        return arrayListPerson;
    }
}
