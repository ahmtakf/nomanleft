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
    private JPanel boosterPanel;
    private JTextField boostersTextField;
    public int flag;
    public boolean candrag;
    public int wallId;
    public int wallX;
    public int wallY;

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
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 1;
            }
        });

    }
    private void createUIComponents() {
        gamePanel = new GamePanel();
        candrag = false;
        flag = 0;
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Point clickCoordinate = e.getPoint();

                if ( e.getButton() == MouseEvent.BUTTON3){
                    int x = (int) (clickCoordinate.getX() - 800)/300;
                    int y = (int) (clickCoordinate.getY() - 50)/300;
                    System.out.println(x + " " + y + " Color: " + ((GamePanel)gamePanel).isBlack(x*2+y, (int)(clickCoordinate.getX() - 800)%300, (int)(clickCoordinate.getY() - 50)%300));
                    if ( !(x < 0 || x > 1 || y < 0 || y > 1) ){
                        if(((GamePanel)gamePanel).isBlack(x*2+y, (int)(clickCoordinate.getX() - 800)%300, (int)(clickCoordinate.getY() - 50)%300) ) {
                            GameManager.getInstance().rotateWallOnPanelRight(x * 2 + y);
                            gamePanel.repaint();
                            gamePanel.validate();
                        }
                    }
                }
                else {
                    int mapPointX = (int) (clickCoordinate.getX() / 120);
                    int mapPointY = (int) (clickCoordinate.getY() / 120);
                    mapPointX = mapPointX * 2;
                    mapPointY = mapPointY * 2;
                    if (clickCoordinate.getX() % 120 > 20)
                        mapPointX++;
                    if (clickCoordinate.getY() % 120 > 20)
                        mapPointY++;

                    if (flag == 1) { // remove
                        GameManager.getInstance().getMapModel().takeWall(mapPointY, mapPointX);
                        gamePanel.repaint();
                        flag = 2;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Point clickCoordinate = e.getPoint();
                int x = (int) (clickCoordinate.getX() - 800)/300;
                int y = (int) (clickCoordinate.getY() - 50)/300;

                if ( e.getButton() == MouseEvent.BUTTON1 && !(x < 0 || x > 1 || y < 0 || y > 1) ){
                    if (((GamePanel) gamePanel).isBlack(x * 2 + y, (int) (clickCoordinate.getX() - 800) % 300, (int) (clickCoordinate.getY() - 50) % 300)) {
                        candrag = true;
                        wallId = 2 * x + y;
                        wallX = (int)(clickCoordinate.getX() - 800) % 300;
                        wallY = (int)(clickCoordinate.getY() - 50) % 300;
                        System.out.println(x + " " + y);
                    }
                    else{
                        candrag = false;
                    }
                }
                else{
                    candrag = false;
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                if (candrag){
                    Point clickCoordinate = e.getPoint();
                    int mapPointX = (int) (clickCoordinate.getX() / 120);
                    int mapPointY = (int) (clickCoordinate.getY() / 120);
                    mapPointX = mapPointX * 2;
                    mapPointY = mapPointY * 2;
                    if (clickCoordinate.getX() % 120 > 20)
                        mapPointX++;
                    if (clickCoordinate.getY() % 120 > 20)
                        mapPointY++;

                    System.out.println("X:" + mapPointX + " Y: " + mapPointY);
                    GameManager.getInstance().putWall(wallId, mapPointY, mapPointX, wallX, wallY);
                    ((GamePanel)gamePanel).resetWallPosition(wallId);
                    candrag = false;
                    gamePanel.repaint();
                    gamePanel.validate();
                    if (GameManager.getInstance().check()) {
                        finishLevel();
                    }

                }

            }
        });
        gamePanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);

                if (candrag){
                    System.out.println("Dragged " + e.getX() + " " + e.getY());
                    ((GamePanel)gamePanel).changeWallPosition(wallId, e.getX(), e.getY(), wallX, wallY);
                    gamePanel.repaint();
                    gamePanel.validate();
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