package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.GameManager;

import com.nullpointers.nomanleft.model.MapObject;
import com.nullpointers.nomanleft.model.Wall;
import com.nullpointers.nomanleft.model.WallTile;
import com.nullpointers.nomanleft.model.Wallable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SandBoxPanel extends JPanel{


    private JPanel sandBoxPanel;
    private JButton back;
    private JPanel internalPanel;

    public SandBoxPanel() {
        super();
        //setBackground(Color.BLUE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GameManager.getInstance().openMainMenu();
            }
        });



    }

    public JPanel getSandBoxPanel() {
        return sandBoxPanel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        internalPanel = new GameSandBoxPanel();
    }
}
