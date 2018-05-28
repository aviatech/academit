package ru.maslenkin.testtaskfromsdek.gui;

import ru.maslenkin.testtaskfromsdek.common.ViewListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrameAddDialog {
    private JDialog dialog = new JDialog();
    private final JLabel label = new JLabel("Имя:");
    private final JTextField textField = new JTextField();
    private final JTextField addNameTextField = new JTextField();
    private JButton okButton = new JButton("OK");
    private JButton cancelButton = new JButton("Отмена");

    public JTextField getAddNameTextField() {
        return addNameTextField;
    }

    JButton getAddButton() {
        return okButton;
    }

    JButton getCancelButton() {
        return cancelButton;
    }

    public JTextField getTextField() {
        return textField;
    }

    void close() {
        dialog.dispose();
    }

    public FrameAddDialog() {
        initDialogView();
        dialog.setTitle("Добавить имя");
        dialog.setMinimumSize(new Dimension(350, 200));
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    private void initDialogView() {
        dialog.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.NONE;
        c1.gridx = 1;
        c1.gridy = 0;
        c1.gridwidth = 5;
        c1.gridheight = 1;
        c1.fill = GridBagConstraints.BOTH;
        c1.insets = new Insets(0, 0, 10, 10);
        dialog.add(textField, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.NONE;
        c2.gridx = 0;
        c2.gridy = 2;
        c2.insets = new Insets(10, 0, 0, 10);
        dialog.add(okButton, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.NONE;
        c3.gridx = 1;
        c3.gridy = 2;
        c3.insets = new Insets(10, 0, 0, 10);
        dialog.add(cancelButton, c3);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.fill = GridBagConstraints.NONE;
        c4.gridx = 0;
        c4.gridy = 0;
        c4.gridwidth = 1;
        c4.gridheight = 1;
        c4.fill = GridBagConstraints.BOTH;
        c4.insets = new Insets(0, 0, 10, 0);
        dialog.add(label, c4);
    }
}
