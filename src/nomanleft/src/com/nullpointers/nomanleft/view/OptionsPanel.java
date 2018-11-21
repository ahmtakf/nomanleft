package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.GameManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsPanel {

    private JCheckBox mute;
    private JSlider volumeBar;
    private JLabel volumeLabel;
    private JButton backButton;
    private JPanel topPanel;
    private JPanel optionsPanel;

    private int volume;
    private int oldVolume;

    public JPanel getOptionsPanel() {
        return optionsPanel;
    }

    public OptionsPanel() {

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GameManager.getInstance().openMainMenu();
            }
        });



    }

    public void mute(){

    }

    public void unMute() {

    }

    public void getVolume() {

    }

}
