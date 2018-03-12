package ru.academit.maslenkin.gui;

import ru.academit.maslenkin.view.View;
import ru.academit.maslenkin.view.ViewListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Александр on 10.03.2018.
 */
public class Frame implements View {
    private final ArrayList<ViewListener> listeners = new ArrayList<>();
    private final JFrame frame = new JFrame();

    /*public Frame() {

        initFrame();
    }*/

    private void initFrame() {
        frame.pack();
        frame.setTitle("Minesweeper");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    private Image getImage(String name) {
        String filename = "images/" + name + ".png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(filename));
        return imageIcon.getImage();
    }

    @Override
    public void startApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initFrame();

            }
        });

    }

    @Override
    public void addViewListener(ViewListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeViewListener(ViewListener listener) {

    }
}
