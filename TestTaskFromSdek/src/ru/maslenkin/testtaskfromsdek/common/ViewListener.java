package ru.maslenkin.testtaskfromsdek.common;

import java.sql.SQLException;

public interface ViewListener {
    void needAddToDatabase(String name) throws SQLException, ClassNotFoundException;
    void needSelectFromDatabase() throws SQLException;
    void needFilteringDatabase(int id, String name) throws SQLException;
    void needConnectDatabase();
}
