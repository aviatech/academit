package ru.maslenkin.testtaskfromsdek.gui;

import javax.swing.*;
import java.awt.*;

public class FrameFilterDialog {
    private JDialog filterDialog = new JDialog();
    private JLabel nameLabel = new JLabel("Имя:");
    private JLabel idLabel = new JLabel("id:");
    private JTextField nameTextField = new JTextField();
    private JTextField id = new JTextField();
    private JButton okButton = new JButton("ОК");
    private JButton cancelButton = new JButton("Отмена");
    FrameFilterDialog() {
        initFilterDialog();
        filterDialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        filterDialog.setMinimumSize(new Dimension(300, 200));
        filterDialog.setLocationRelativeTo(null);
        filterDialog.setVisible(true);
    }

    JTextField getNameTextField() {
        return nameTextField;
    }

    JTextField getId() {
        return id;
    }

    public JDialog getFilterDialog() {
        return filterDialog;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    JButton getOkButton() {
        return okButton;
    }

    JButton getCancelButton() {
        return cancelButton;
    }

    void close() {
        this.filterDialog.dispose();
    }

    private void initFilterDialog() {
        filterDialog.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridwidth = 3;
        c1.gridheight = 1;
        c1.fill = GridBagConstraints.BOTH;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = new Insets(0, 0, 10, 0);
        filterDialog.add(nameLabel, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 1;
        c2.gridy = 0;
        c2.gridwidth = 3;
        c2.gridheight = 1;
        c2.fill = GridBagConstraints.BOTH;
        c2.insets = new Insets(0, 0, 10, 0);
        filterDialog.add(nameTextField, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 2;
        c3.gridwidth = 3;
        c3.gridheight = 1;
        c3.fill = GridBagConstraints.BOTH;
        c3.anchor = GridBagConstraints.CENTER;
        c3.insets = new Insets(0, 0, 10, 0);
        filterDialog.add(idLabel, c3);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 1;
        c4.gridy = 2;
        c4.gridwidth = 3;
        c4.gridheight = 1;
        c4.fill = GridBagConstraints.BOTH;
        c4.insets = new Insets(0, 0, 10, 0);
        filterDialog.add(id, c4);

        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 0;
        c5.gridy = 4;
        c5.gridwidth = 1;
        c5.gridheight = 1;
        c5.insets = new Insets(0, 0, 10, 10);
        filterDialog.add(okButton, c5);

        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridx = 1;
        c6.gridy = 4;
        c6.gridwidth = 1;
        c6.gridheight = 1;
        c6.insets = new Insets(0, 10, 10, 0);
        filterDialog.add(cancelButton, c6);
    }
}
