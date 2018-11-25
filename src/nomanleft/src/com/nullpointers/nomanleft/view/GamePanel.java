package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.GameManager;
import com.nullpointers.nomanleft.model.Ground;
import com.nullpointers.nomanleft.model.MapObject;
import com.nullpointers.nomanleft.model.Tower;
import com.nullpointers.nomanleft.model.WallTile;

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
        for(int i = 0; i < 13; i++){
            for(int k = 0; k < 13; k++){
                if ( i % 2 == 0 && k % 2 == 0){
                    g.setColor(Color.PINK);
                    if (map[i][k] instanceof WallTile){
                        g.setColor(Color.BLACK);
                    }
                    g.fillRect((k/2)*120,(i/2)*120,20,20);
                }
                if ( i % 2 == 1 && k % 2 == 0){
                    g.setColor(Color.PINK);
                    if (map[i][k] instanceof WallTile){
                        g.setColor(Color.BLACK);
                    }
                    if (map[i][k] instanceof Tower){
                        g.drawImage((map[i][k]).getImage(),(k/2)*120,(i/2)*120+20,20,100,null);
                        continue;
                    }
                    g.fillRect((k/2)*120,(i/2)*120+20,20,100);
                }
                if ( i % 2 == 0 && k % 2 == 1){
                    g.setColor(Color.PINK);
                    if (map[i][k] instanceof WallTile){
                        g.setColor(Color.BLACK);
                    }
                    if (map[i][k] instanceof Tower){
                        g.drawImage((map[i][k]).getImage(),(k/2)*120+20,(i/2)*120,100,20,null);
                        continue;
                    }
                    g.fillRect((k/2)*120+20,(i/2)*120,100,20);
                }
                if ( i % 2 == 1 && k % 2 == 1){
                    g.drawImage((map[i][k]).getImage(),(k/2)*120+20,(i/2)*120+20,100,100,null);
                }
            }
        }
    }
}
