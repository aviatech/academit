package ru.maslenkin.testtaskfromsdek.gui;

import ru.maslenkin.testtaskfromsdek.model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class FrameLoadDatabase {
    private JDialog dialog = new JDialog();
    private JButton filterButton = new JButton("Фильтр");
    private JButton cancelButton = new JButton("Отмена");
    private JScrollPane scrollPane;
    private JTable table;


    JButton getFilterButton() {
        return filterButton;
    }

    JButton getCancelButton() {
        return cancelButton;
    }


    void close() {
        dialog.dispose();
    }

    public FrameLoadDatabase(ArrayList<Person> personArrayList) {
        initTable(personArrayList);
        initLoadDialog();
        dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dialog.setMinimumSize(new Dimension(390, 390));
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void initTable(ArrayList<Person> result) {
        scrollPane = new JScrollPane(table);
        String[] columnNames = {"ID", "NAMES"};
        Object[][] data = new Object[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            Person element = result.get(i);
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    data[i][j] = element.getId();
                } else {
                    data[i][j] = element.getName();
                }
            }
        }
        TableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
    }

    private void initLoadDialog() {
        dialog.setLayout(new BorderLayout());
        JPanel panel = new JPanel();

        dialog.add(panel, BorderLayout.PAGE_START);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.insets = new Insets(10, 0, 10, 0);
        panel.add(filterButton, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 1;
        c2.gridy = 0;
        c2.insets = new Insets(10, 0, 10, 0);
        panel.add(cancelButton, c2);

        dialog.add(scrollPane, BorderLayout.CENTER);
    }
}

