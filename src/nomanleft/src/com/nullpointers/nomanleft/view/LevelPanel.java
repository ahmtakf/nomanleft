package com.nullpointers.nomanleft.view;


import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    private JLabel timeLeftLabel;
    private JLabel levelsSolvedLabel;
    private JLabel highScoreLabel;
    private JButton FillButton;
    private JButton MoveButton;
    private JButton DigButton;
    private JButton HideButton;
    private JTextField Bush;
    private JTextField numberOfHide;
    private JTextField numberOfDig;
    private JTextField numberOfMove;
    private JTextField numberOfFill;
    public int flag;
    public boolean candrag;
    public boolean changeDirection;
    public int wallId;
    public int wallX;
    public int wallY;
    public boolean timeTrial = false;
    public int initialSoliderX;
    public int initialSoliderY;

    public LevelPanel() {
        super();
        HideButton.setIcon(new ImageIcon(FileManager.getInstance().getBush()));
        numberOfHide.setText(Integer.toString(FileManager.getInstance().getHideBooster()));
        DigButton.setIcon(new ImageIcon(FileManager.getInstance().getDigImage()));
        numberOfDig.setText(Integer.toString(FileManager.getInstance().getDigBooster()));
        MoveButton.setIcon(new ImageIcon(FileManager.getInstance().getMoveImage()));
        numberOfMove.setText(Integer.toString(FileManager.getInstance().getMoveBooster()));
        FillButton.setIcon(new ImageIcon(FileManager.getInstance().getFillImage()));
        numberOfFill.setText(Integer.toString(FileManager.getInstance().getFillBooster()));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yesNoOption = JOptionPane.showConfirmDialog(null,"Are you sure to Exit ? ", "Close",JOptionPane.YES_NO_OPTION);
                if(yesNoOption == JOptionPane.YES_NO_OPTION){
                    //System.exit(0);
                    if(timeTrial)
                    GameManager.getInstance().finishTimeTrial();
                    else
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
        HideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 2;
            }
        });
        DigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 4;
            }
        });
        MoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 5;
            }
        });
        FillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 3;
            }
        });

        timeLeftLabel.setVisible(this.timeTrial);
        levelsSolvedLabel.setVisible(this.timeTrial);
        highScoreLabel.setVisible(this.timeTrial);
    }

    public LevelPanel(boolean timeTrial, int highScore, int levelCount) {
        this();
        this.timeTrial = timeTrial;

        timeLeftLabel.setVisible(this.timeTrial);
        levelsSolvedLabel.setVisible(this.timeTrial);
        highScoreLabel.setVisible(this.timeTrial);

        highScoreLabel.setText("High Score: " + highScore);
        levelsSolvedLabel.setText("Levels Solved: " + levelCount);
    }

    private void createUIComponents() {


        gamePanel = new GamePanel();
        candrag = false;
        changeDirection = false;
        flag = 0;
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Point clickCoordinate = e.getPoint();
                if ( candrag){
                    ((GamePanel)gamePanel).resetWallPosition(wallId);
                    candrag = false;
                    gamePanel.repaint();
                    gamePanel.validate();
                    System.out.println("Do not Click while dragging!");
                }
                else{
                    int x = (int) (clickCoordinate.getX() - 800)/300;
                    int y = (int) (clickCoordinate.getY() - 50)/300;
                    if ( x >= 0 && y >= 0 && x < 2 && y < 2 && e.getButton() == MouseEvent.BUTTON3){
                        System.out.println(x + " " + y + " Color: " + ((GamePanel)gamePanel).isBlack(x*2+y, (int)(clickCoordinate.getX() - 800)%300, (int)(clickCoordinate.getY() - 50)%300));
                        if(((GamePanel)gamePanel).isBlack(x*2+y, (int)(clickCoordinate.getX() - 800)%300, (int)(clickCoordinate.getY() - 50)%300) ) {
                            GameManager.getInstance().rotateWallOnPanelRight(x * 2 + y);
                            gamePanel.repaint();
                            gamePanel.validate();
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
                        if(flag == 2){ // hide booster
                            if(Integer.parseInt(numberOfHide.getText()) > 0){
                                GameManager.getInstance().hide(mapPointY,mapPointX);
                                gamePanel.repaint();
                                numberOfHide.setText(Integer.toString(FileManager.getInstance().getHideBooster()));
                            }
                            else{
                                JOptionPane.showMessageDialog(gamePanel, "You don't have enough Hide booster.");
                            }
                            flag = 0;
                        }
                        else if(flag == 3){ // fill booster
                            if(Integer.parseInt(numberOfFill.getText()) > 0){
                                GameManager.getInstance().fill(mapPointY,mapPointX);
                                gamePanel.repaint();
                                numberOfFill.setText(Integer.toString(FileManager.getInstance().getFillBooster()));
                            }
                            else{
                                JOptionPane.showMessageDialog(gamePanel, "You don't have enough Fill booster.");
                            }
                            flag = 0;
                        }
                        else if(flag == 4) { // dig booster
                            if(Integer.parseInt(numberOfDig.getText()) > 0){
                                GameManager.getInstance().dig(mapPointY, mapPointX);
                                gamePanel.repaint();

                                numberOfDig.setText(Integer.toString(FileManager.getInstance().getDigBooster()));
                            }
                            else{
                                JOptionPane.showMessageDialog(gamePanel, "You don't have enough Dig booster.");
                            }
                            flag = 0;
                        }
                        else if (flag == 1) { // remove
                            GameManager.getInstance().getMapModel().takeWall(mapPointY, mapPointX);
                            gamePanel.repaint();
                            flag = 0;
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Point clickCoordinate = e.getPoint();
                double a = (clickCoordinate.getX() - 800)/300;
                double b = (clickCoordinate.getY() - 50)/300;
                int x;
                int y;
                if ( a < 0){
                    x = -1;
                }
                else {
                    x = (int)a;
                }
                if ( b < 0){
                    y = -1;
                }
                else{
                    y = (int)b;
                }

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

                int mapPointX = (int) (clickCoordinate.getX() / 120);
                int mapPointY = (int) (clickCoordinate.getY() / 120);
                mapPointX = mapPointX * 2;
                mapPointY = mapPointY * 2;
                if (clickCoordinate.getX() % 120 > 20)
                    mapPointX++;
                if (clickCoordinate.getY() % 120 > 20)
                    mapPointY++;
                if(flag == 5){ // move booster
                    changeDirection = true;
                    initialSoliderX = mapPointX;
                    initialSoliderY = mapPointY;
                    gamePanel.repaint();
                    flag = 0;
                }


            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                Point clickCoordinate = e.getPoint();
                int mapPointX = (int) (clickCoordinate.getX() / 120);
                int mapPointY = (int) (clickCoordinate.getY() / 120);
                mapPointX = mapPointX * 2;
                mapPointY = mapPointY * 2;
                if (clickCoordinate.getX() % 120 > 20)
                    mapPointX++;
                if (clickCoordinate.getY() % 120 > 20)
                    mapPointY++;
                if (candrag && e.getButton() == MouseEvent.BUTTON1){
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
                else if(changeDirection){
                    if(Integer.parseInt(numberOfMove.getText()) > 0) {
                        if (mapPointX - initialSoliderX == 0 && mapPointY - initialSoliderY > 0)
                            GameManager.getInstance().move(initialSoliderY, initialSoliderX, 3);
                        else if (mapPointX - initialSoliderX == 0 && mapPointY - initialSoliderY < 0)
                            GameManager.getInstance().move(initialSoliderY, initialSoliderX, 2);
                        else if (mapPointX - initialSoliderX > 0 && mapPointY - initialSoliderY == 0)
                            GameManager.getInstance().move(initialSoliderY, initialSoliderX, 1);
                        else if (mapPointX - initialSoliderX < 0 && mapPointY - initialSoliderY == 0)
                            GameManager.getInstance().move(initialSoliderY, initialSoliderX, 0);
                        gamePanel.repaint();
                        gamePanel.validate();
                        if (GameManager.getInstance().check()) {
                            finishLevel();
                        }
                        numberOfMove.setText(Integer.toString(FileManager.getInstance().getMoveBooster()));
                    }
                    else{
                        JOptionPane.showMessageDialog(gamePanel, "You don't have enough Move booster.");
                    }
                    changeDirection = false;
                }
                else{
                    ((GamePanel)gamePanel).resetWallPosition(wallId);
                    gamePanel.repaint();
                    gamePanel.validate();
                    candrag = false;
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
        if (!timeTrial) {
            JOptionPane.showMessageDialog(this, "Congratulations");
            GameManager.getInstance().rewardGold(1);
            GameManager.getInstance().openPlayGamePanel();
        }
        if (timeTrial) {
            //reward when whole timeTrial thing finishes
            GameManager.getInstance().loadNextLevel();
        }
    }

    public void updateTimeLabel(String time){
        timeLeftLabel.setText(time);
    }
}