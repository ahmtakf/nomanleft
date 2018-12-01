package com.nullpointers.nomanleft.view;


import com.nullpointers.nomanleft.controller.GameManager;
import com.nullpointers.nomanleft.model.Wall;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LevelPanel extends JPanel{
    private JPanel levelPanel;
    private JPanel gamePanel;
    private JPanel boosterPanel;
    private JPanel wallPanel;
    private JTextField boostersTextField;
    private JTextField wallsTextField;
    private JButton back;
    private JButton left4;
    private JButton left3;
    private JButton left2;
    private JButton left1;
    private JButton right4;
    private JButton right3;
    private JButton right2;
    private JButton right1;
    private JButton removeButton;
    private Wall clickedWall;
    public boolean flag = true;
    private ArrayList<Wall> walls = GameManager.getInstance().getMapModel().getWalls();

    public LevelPanel() {
        super();
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yesNoOption = JOptionPane.showConfirmDialog(null,"Are you sure to Exit ? ", "Close",JOptionPane.YES_NO_OPTION);
                if(yesNoOption == JOptionPane.YES_NO_OPTION){
                    //System.exit(0);
                    GameManager.getInstance().openPlayGamePanel();
                }
            }
        });
        right1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelRight(walls.get(0));
                gamePanel.repaint();
                validate();
            }
        });
        right2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelRight(walls.get(1));
                gamePanel.repaint();
                validate();
            }
        });
        right3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelRight(walls.get(2));
                gamePanel.repaint();
                validate();
            }
        });
        right4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelRight(walls.get(3));
                gamePanel.repaint();
                validate();
            }
        });
        left1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelLeft(walls.get(0));
                gamePanel.repaint();
                validate();
            }
        });
        left2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelLeft(walls.get(1));
                gamePanel.repaint();
                validate();
            }
        });
        left3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelLeft(walls.get(2));
                gamePanel.repaint();
                validate();
            }
        });
        left4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelLeft(walls.get(3));
                gamePanel.repaint();
                validate();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = false;
            }
        });

    }
    private void createUIComponents() {
        gamePanel = new GamePanel();

        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Point clickCoordinate = e.getPoint();

                //System.out.println(clickCoordinate);
                int mapPointX = (int) (clickCoordinate.getX() / 120);
                int mapPointY = (int) (clickCoordinate.getY() / 120);
                mapPointX = mapPointX * 2;
                mapPointY = mapPointY * 2;
                if (clickCoordinate.getX() % 120 > 20)
                    mapPointX++;
                if (clickCoordinate.getY() % 120 > 20)
                    mapPointY++;

                if(flag){
                    if (clickedWall != null){

                        System.out.println("X:" + mapPointX + " Y: " + mapPointY);
                        GameManager.getInstance().putWall(clickedWall,mapPointY,mapPointX);
                        clickedWall = null;
                        gamePanel.repaint();
                        if (GameManager.getInstance().check()){
                            finishLevel();
                        }
                    }
                }
                else{
                    GameManager.getInstance().getMapModel().takeWall(mapPointY,mapPointX);
                    gamePanel.repaint();
                    flag = true;
                }

            }
        });
        repaint();
        validate();
    }

    public JPanel getLevelPanel() {
        return levelPanel;
    }

    public void finishLevel() {
        JOptionPane.showMessageDialog(this,"Congragulations");
        GameManager.getInstance().openPlayGamePanel();
    }

}