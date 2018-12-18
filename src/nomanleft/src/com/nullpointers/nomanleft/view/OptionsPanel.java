package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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


        mute.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                FileManager.getInstance().changeSound();
            }
        });

        mute.setSelected(FileManager.getInstance().getSound() == 0 );
        volumeBar.setValue(FileManager.getInstance().getSoundLevel());

        volumeBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider temp = (JSlider)e.getSource();
                FileManager.getInstance().setSoundLevel(temp.getValue());
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
