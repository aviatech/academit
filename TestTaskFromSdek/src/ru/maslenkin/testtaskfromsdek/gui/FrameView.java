package ru.maslenkin.testtaskfromsdek.gui;

import ru.maslenkin.testtaskfromsdek.common.View;
import ru.maslenkin.testtaskfromsdek.common.ViewListener;
import ru.maslenkin.testtaskfromsdek.model.ConnectionDatabase;
import ru.maslenkin.testtaskfromsdek.model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class FrameView implements View {
    private final ArrayList<ViewListener> listeners = new ArrayList<>();
    private JFrame frame = new JFrame("Тестовое задание");
    private JButton addButton = new JButton("Добавить");
    private JButton loadButton = new JButton("Загрузить");
    private final static int HORIZONTAL_INSET = 10;
    private final static int VERTICAL_INSET = 5;

    private void initFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initContent() {
        JPanel panel = new JPanel(new GridBagLayout());
        Insets insets = new Insets(0, HORIZONTAL_INSET, 0, HORIZONTAL_INSET);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridwidth = 1;
        c1.gridheight = 1;
        c1.weighty = 1.0;
        c1.anchor = GridBagConstraints.NORTHWEST;
        c1.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, 0, HORIZONTAL_INSET);
        panel.add(addButton, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 1;
        c2.gridy = 0;
        c2.gridwidth = 1;
        c2.gridheight = 1;
        c2.weighty = 1.0;
        c2.anchor = GridBagConstraints.NORTHEAST;
        c2.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, VERTICAL_INSET, HORIZONTAL_INSET);
        panel.add(loadButton, c2);
        frame.setContentPane(panel);
    }

    private void initEvents() throws SQLException {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        connectionDatabase.connect();
        for (ViewListener listener : listeners) {
            listener.needConnectDatabase();
        }
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameAddDialog frameAddDialog = new FrameAddDialog();
                frameAddDialog.getCancelButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frameAddDialog.close();
                    }
                });
                frameAddDialog.getAddButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = frameAddDialog.getTextField().getText();
                        frameAddDialog.close();
                        for (ViewListener listener : listeners) {
                            try {
                                listener.needAddToDatabase(name);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            } catch (ClassNotFoundException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
                try {
                    frameAddDialog.getAddNameTextField();
                } catch (NumberFormatException ex) {
                    System.out.println();
                }
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ViewListener listener : listeners) {
                    try {
                        listener.needSelectFromDatabase();

                    } catch (SQLException e1) {
                    }
                }
            }
        });
    }

    @Override
    public void startApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initFrame();
                initContent();
                try {
                    initEvents();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void outputDataBase(ArrayList<Person> personArrayList) {
        FrameLoadDatabase frameLoadDatabase = new FrameLoadDatabase(personArrayList);
        frameLoadDatabase.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameLoadDatabase.close();
            }
        });
        frameLoadDatabase.getFilterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameFilterDialog filterDialog = new FrameFilterDialog();
                filterDialog.getCancelButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        filterDialog.close();
                    }
                });
                filterDialog.getOkButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id;
                        String name;
                        filterDialog.close();
                        try {
                            id = Integer.parseInt(filterDialog.getId().getText());
                        } catch (IllegalArgumentException e1) {
                            id = 0;
                        }
                        try {
                            name = filterDialog.getNameTextField().getText();
                        } catch (IllegalArgumentException e2) {
                            name = null;
                        }
                        for (ViewListener listener : listeners) {
                            try {
                                listener.needFilteringDatabase(id, name);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
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

    @Override
    public void close() throws Exception {
        frame.dispose();
    }
}
