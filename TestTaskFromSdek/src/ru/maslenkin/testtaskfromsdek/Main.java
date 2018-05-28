package ru.maslenkin.testtaskfromsdek;

import ru.maslenkin.testtaskfromsdek.common.View;
import ru.maslenkin.testtaskfromsdek.controller.Controller;
import ru.maslenkin.testtaskfromsdek.gui.FrameView;
import ru.maslenkin.testtaskfromsdek.model.ConnectionDatabase;

public class Main {
    public static void main(String[] args) {
        FrameView view = new FrameView();
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        Controller controller = new Controller(view, connectionDatabase);
        view.addViewListener(controller);
        view.startApplication();
    }
}
