package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.GameManager;
import com.nullpointers.nomanleft.model.MapObject;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private MapObject[][] map;
    public GamePanel() {
        super();
        map = GameManager.getInstance().getMapModel().getMap();
        repaint();
        validate();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++){
                g.drawImage((map[i][k]).getImage(),k*100,i*100,100,100,null);
            }
        }
    }
}
