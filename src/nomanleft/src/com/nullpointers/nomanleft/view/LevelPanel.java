package com.nullpointers.nomanleft.view;



import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;
import com.nullpointers.nomanleft.model.Wall;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private JButton right5;
    private JButton right4;
    private JButton right3;
    private JButton right2;
    private JButton right1;
    private JPanel wallPanel1;
    private JPanel wallPanel2;
    private JPanel wallPanel3;
    private JPanel wallPanel4;
    private JPanel wallPanel5;
    private Wall clickedWall;
    ArrayList<Wall> walls = GameManager.getInstance().getMapModel().getWalls();
    ArrayList<Wall> wallsCopy = new ArrayList<>(walls);


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
                wallPanel1 = new WallPanel(walls.get(0));
                wallPanel.repaint();
                validate();
            }
        });
        right2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelRight(walls.get(1));
                wallPanel2 = new WallPanel(walls.get(1));
                wallPanel.repaint();
                validate();
            }
        });
        right3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelRight(walls.get(2));
                wallPanel3 = new WallPanel(walls.get(2));
                wallPanel.repaint();
                validate();
            }
        });
        right4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelRight(walls.get(3));
                wallPanel4 = new WallPanel(walls.get(3));
                wallPanel.repaint();
                validate();
            }
        });
        right5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelRight(walls.get(4));
                wallPanel5 = new WallPanel(walls.get(4));
                wallPanel.repaint();
                validate();
            }
        });
        left1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelLeft(walls.get(0));
                wallPanel1 = new WallPanel(walls.get(0));
                wallPanel.repaint();
                validate();
            }
        });
        left2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelLeft(walls.get(1));
                wallPanel2 = new WallPanel(walls.get(1));
                wallPanel.repaint();
                validate();
            }
        });
        left3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelLeft(walls.get(2));
                wallPanel3 = new WallPanel(walls.get(2));
                wallPanel.repaint();
                validate();
            }
        });
        right4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelLeft(walls.get(3));
                wallPanel4 = new WallPanel(walls.get(3));
                wallPanel.repaint();
                validate();
            }
        });
        right5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().rotateWallOnPanelLeft(walls.get(4));
                wallPanel5 = new WallPanel(walls.get(4));
                wallPanel.repaint();
                validate();
            }
        });

    }


    private void createUIComponents() {
        gamePanel = new GamePanel();

        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (clickedWall != null){
                    Point clickCoordinate = e.getPoint();

                    //System.out.println(clickCoordinate);
                    int mapPointX = (int) (clickCoordinate.getX() / 100) ;
                    int mapPointY = (int) (clickCoordinate.getY() / 100) ;

                    System.out.println("X:" + mapPointX + " Y: " + mapPointY);
                    GameManager.getInstance().PutWall(clickedWall,mapPointY,mapPointX);
                    if(GameManager.getInstance().isMapModelChanged()){
                        if(clickedWall.getId() == walls.get(0).getId()){
                            System.out.println("adfsgfdhjjk");
                            wallPanel1 = new JPanel();
                        }
                        else if(clickedWall.getId() == walls.get(1).getId()){
                            wallPanel2 = new JPanel();
                        }
                        else if(clickedWall.getId() == walls.get(2).getId()){
                            wallPanel3 = new JPanel();
                        }
                        else if(clickedWall.getId() == walls.get(3).getId()){
                            wallPanel4 = new JPanel();
                        }
                        else if(clickedWall.getId() == walls.get(4).getId()){
                            wallPanel5 = new JPanel();
                        }
                    }
                    clickedWall = null;
                    gamePanel.repaint();
                    wallPanel.repaint();
                    gamePanel.validate();
                    wallPanel.validate();
                }
            }
        });
        ArrayList<Wall> walls = GameManager.getInstance().getMapModel().getWalls();
        if (walls.size() > 0){
            wallPanel1 = new WallPanel(walls.get(0));
            wallPanel1.addMouseListener(new WallClickAdapter());
        }
        else{
            wallPanel1 = new JPanel();
        }
        wallPanel1.addMouseListener(new WallClickAdapter());
        if (walls.size() > 1){
            wallPanel2 = new WallPanel(walls.get(1));
            wallPanel2.addMouseListener(new WallClickAdapter());
        }
        else{
            wallPanel2 = new JPanel();
        }
        if (walls.size() > 2){
            wallPanel3 = new WallPanel(walls.get(2));
            wallPanel3.addMouseListener(new WallClickAdapter());
        }
        else{
            wallPanel3 = new JPanel();
        }
        if (walls.size() > 3){
            wallPanel4 = new WallPanel(walls.get(3));
            wallPanel4.addMouseListener(new WallClickAdapter());
        }
        else{
            wallPanel4 = new JPanel();
        }
        if (walls.size() > 4){
            wallPanel5 = new WallPanel(walls.get(4));
            wallPanel5.addMouseListener(new WallClickAdapter());
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

   private class WallClickAdapter extends MouseAdapter {
       @Override
       public void mouseClicked(MouseEvent e) {
           super.mouseClicked(e);
           WallPanel tmp = (WallPanel)e.getSource();
           clickedWall = tmp.getWall();
           System.out.println("wall click");
       }

   }

}
