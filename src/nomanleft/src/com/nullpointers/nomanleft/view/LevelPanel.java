package com.nullpointers.nomanleft.view;



import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;
import com.nullpointers.nomanleft.model.Wall;

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
    private JPanel levelPanel;
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
    private JPanel wallPanel5;

    public LevelPanel() {
        super();

        System.out.println("sadfghfh");

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yesNoOption = JOptionPane.showConfirmDialog(null,"Are you sure to Exit ? ", "Close",JOptionPane.YES_NO_OPTION);
                if(yesNoOption == JOptionPane.YES_NO_OPTION){
                    //System.exit(0);
                    GameManager.getInstance().openMainMenu();
                }
            }
        });
    }


    private void createUIComponents() {
        gamePanel = new GamePanel();

        ArrayList<Wall> walls = GameManager.getInstance().getMapModel().getWalls();
        if (walls.size() > 0){
            wallPanel1 = new WallPanel(walls.get(0));
        }
        else{
            wallPanel1 = new JPanel();
        }
        if (walls.size() > 1){
            wallPanel2 = new WallPanel(walls.get(1));
        }
        else{
            wallPanel2 = new JPanel();
        }
        if (walls.size() > 2){
            wallPanel3 = new WallPanel(walls.get(2));
        }
        else{
            wallPanel3 = new JPanel();
        }
        if (walls.size() > 3){
            wallPanel4 = new WallPanel(walls.get(3));
        }
        else{
            wallPanel4 = new JPanel();
        }
        if (walls.size() > 4){
            wallPanel5 = new WallPanel(walls.get(4));
        }
        else{
            wallPanel5 = new JPanel();
        }

        repaint();
        validate();
    }

    public JPanel getLevelPanel() {
        return levelPanel;
    }
}
