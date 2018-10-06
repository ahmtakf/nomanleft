package com.nullpointers.nomanleft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel{
    private JTextArea helloWorldTextArea;
    private JButton helloFromOtherWorldButton;
    private JPanel mainPanel;

    public MainPanel() {
        mainPanel.setSize(800, 800);
        helloFromOtherWorldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello!");
            }
        });
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

}
