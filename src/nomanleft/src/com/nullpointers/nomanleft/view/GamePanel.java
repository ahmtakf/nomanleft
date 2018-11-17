package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.GameManager;
import com.nullpointers.nomanleft.model.MapModel;
import com.nullpointers.nomanleft.model.MapObject;

import java.awt.*;

public class GamePanel extends LevelPanel{
    MapObject[][] map;
    public GamePanel() {
        map = new MapObject[8][8];
        map = GameManager.getInstance().getMapModel().getMap();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++){
                g.drawImage((map[i][k]).getImage(),i*100,i*100,null);
            }
        }
    }
}
