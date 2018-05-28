package ru.maslenkin.testtaskfromsdek.controller;

import ru.maslenkin.testtaskfromsdek.common.ViewListener;
import ru.maslenkin.testtaskfromsdek.gui.FrameView;
import ru.maslenkin.testtaskfromsdek.model.ConnectionDatabase;

import java.sql.SQLException;

public class Controller implements ViewListener {
    private FrameView view;
    private ConnectionDatabase connectionDatabase;

    public Controller(FrameView view, ConnectionDatabase connectionDatabase) {
        this.view = view;
        this.connectionDatabase = connectionDatabase;
    }

    public FrameView getView() {
        return view;
    }

    public void setView(FrameView view) {
        this.view = view;
    }

    public ConnectionDatabase getConnectionDatabase() {
        return connectionDatabase;
    }

    public void setConnectionDatabase(ConnectionDatabase connectionDatabase) {
        this.connectionDatabase = connectionDatabase;
    }

    @Override
    public void needAddToDatabase(String name) throws SQLException, ClassNotFoundException {
        connectionDatabase.addPerson(name);
    }

    @Override
    public void needSelectFromDatabase() throws SQLException {
        view.outputDataBase(connectionDatabase.getPerson());
    }

    @Override
    public void needFilteringDatabase(int id, String name) throws SQLException {
        view.outputDataBase(connectionDatabase.getFilterDatabase(id, name));
    }

    @Override
    public void needConnectDatabase() {

    }
}
