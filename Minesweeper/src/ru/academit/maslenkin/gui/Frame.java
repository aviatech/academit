package ru.academit.maslenkin.gui;

import ru.academit.maslenkin.model.Cell;
import ru.academit.maslenkin.model.MinesweeperImages;
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
    private int ROWS = 9;
    private int COLUMNS = 9;
    private int IMAGE_SIZE = 40;
    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (MinesweeperImages minesweeperImages : MinesweeperImages.values()) {
                Cell cell = new Cell(minesweeperImages.ordinal() * IMAGE_SIZE, 0);
                g.drawImage((Image) minesweeperImages.image, cell.getRow(), cell.getColumn(), this);
            }
        }
    };

    private void initFrame() {

          //Board board = new Board(ROWS, COLUMNS);
        frame.pack();
        frame.setIconImage(getImage("iconMinesweeper"));
        frame.setTitle("Minesweeper");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void initPanel() {
        panel.setPreferredSize(new Dimension(COLUMNS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        frame.add(panel);
    }

    private void setImages() {
        for (MinesweeperImages minesweeperImages : MinesweeperImages.values()) {
            minesweeperImages.image = getImage(minesweeperImages.name().toLowerCase());
        }
    }

    private Image getImage(String name) {
        String filename = "ru/academit/maslenkin/resources/" + name + ".png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(filename));
        return imageIcon.getImage();
    }

    @Override
    public void startApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setImages();
                initPanel();
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
