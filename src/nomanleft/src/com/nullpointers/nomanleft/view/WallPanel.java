package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.model.Wall;

import javax.swing.*;
import java.awt.*;

public class WallPanel extends JPanel {

    private Wall wall;
    private int[][] wallShape;
    private final int MAP_SIZE = 13;

    public WallPanel(Wall wall){
        super();
        this.wall = wall;
        wallShape = wall.getShape();
       /* this.setPreferredSize(new Dimension(200,80));
        this.setVisible(true);*/
        repaint();
        validate();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int i = 0; i < MAP_SIZE; i++){
            for(int j = 0; j < MAP_SIZE; j++){
                if (wallShape[i][j] == 1){
                    g.setColor(Color.WHITE);
                }
                else if (wallShape[i][j] == 2){
                    g.setColor(Color.RED);
                }
                else{
                    g.setColor(Color.DARK_GRAY);
                }
                g.fillRect(68 + j * 5,8 + i * 5,5,5);
            }
        }

    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }
    public void removeWall(Wall wall){

    }
}
