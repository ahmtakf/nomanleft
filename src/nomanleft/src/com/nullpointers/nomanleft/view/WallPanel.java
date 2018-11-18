package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.model.MapModel;
import com.nullpointers.nomanleft.model.MapObject;
import com.nullpointers.nomanleft.model.Wall;

import javax.swing.*;
import java.awt.*;

public class WallPanel extends JPanel {

    private Wall wall;
    private int[][] wallShape;

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

        for (int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (wallShape[i][j] == 1){
                    g.setColor(Color.WHITE);
                }
                else if (wallShape[i][j] == 2){
                    g.setColor(Color.RED);
                }
                else{
                    g.setColor(Color.DARK_GRAY);
                }
                g.fillRect(68 + j * 8,8 + i * 8,8,8);
            }
        }

    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }
}
