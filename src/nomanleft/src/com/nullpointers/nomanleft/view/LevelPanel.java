package com.nullpointers.nomanleft.view;



import com.nullpointers.nomanleft.controller.FileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class LevelPanel extends JPanel{
    public JPanel levelPanel;
    private JPanel gamePanel;
    private JPanel boosterPanel;
    private JPanel wallPanel;
    private JTextField boostersTextField;
    private JTextField wallsTextField;
    private JButton back;
    private JButton left5;
    private JButton left4;
    private JButton left3;
    private JButton left2;
    private JButton left1;
    private JButton right4;
    private JButton right3;
    private JButton right2;
    private JButton right1;
    private JPanel wallPanel1;
    private JPanel wallPanel2;
    private JPanel wallPanel3;
    private JPanel wallPanel4;

    public LevelPanel() {
        super();
        System.out.println("sadfghfh");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yesNoOption = JOptionPane.showConfirmDialog(null,"Are you sure to Exit ? ", "Close",JOptionPane.YES_NO_OPTION);
                if(yesNoOption == JOptionPane.YES_NO_OPTION){
                    System.exit(0);
                }
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        gamePanel = new GamePanel();

    }
}
