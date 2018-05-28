package ru.maslenkin.testtaskfromsdek.common;

import ru.maslenkin.testtaskfromsdek.model.Person;

import java.util.ArrayList;

public interface View extends AutoCloseable {
    void startApplication();
    void outputDataBase(ArrayList<Person> personArrayList);

    void addViewListener(ViewListener listener);
    void removeViewListener(ViewListener listener);
}
