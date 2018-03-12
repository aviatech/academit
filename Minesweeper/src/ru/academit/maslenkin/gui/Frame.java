package ru.academit.maslenkin.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Александр on 10.03.2018.
 */
public class Frame extends JFrame {

    public Frame() {

        initFrame();
    }

    private void initFrame() {
        pack();
        setTitle("Minesweeper");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    private Image getImage(String name) {
        String filename = "image/" + name + ".png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(filename));
        return imageIcon.getImage();
    }

}
