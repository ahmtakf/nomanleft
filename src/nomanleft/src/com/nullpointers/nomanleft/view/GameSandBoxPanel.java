package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;
import com.nullpointers.nomanleft.model.MapObject;
import com.nullpointers.nomanleft.model.WallTile;
import com.nullpointers.nomanleft.model.Wallable;

import javax.swing.*;
import java.awt.*;

public class GameSandBoxPanel extends JPanel {
    private MapObject[][] map;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    public GameSandBoxPanel(){
        super();
        map = GameManager.getInstance().getMapModel().getMap();
        //internalComponent();
        repaint();
        validate();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int i = 0; i < 13; i++){
            for(int k = 0; k < 13; k++){
                if ( i % 2 == 0 && k % 2 == 0){
                    if (map[i][k] instanceof Wallable){
                        g.setColor(Color.PINK);

                    }
                    else if (map[i][k] instanceof WallTile){
                        g.setColor(Color.BLACK);
                    }
                    else{
                        g.drawImage((map[i][k]).getImage(),(k/2)*120,(i/2)*120,20,20,null);
                        continue;
                    }
                    g.fillRect((k/2)*120,(i/2)*120,20,20);
                }
                if ( i % 2 == 1 && k % 2 == 0){
                    if (map[i][k] instanceof Wallable){
                        g.setColor(Color.PINK);
                    }
                    else if (map[i][k] instanceof WallTile){
                        g.setColor(Color.BLACK);
                    }
                    else{
                        g.drawImage((map[i][k]).getImage(),(k/2)*120,(i/2)*120 + 20,20,100,null);
                        continue;
                    }
                    g.fillRect((k/2)*120,(i/2)*120+20,20,100);
                }
                if ( i % 2 == 0 && k % 2 == 1){
                    if (map[i][k] instanceof Wallable){
                        g.setColor(Color.PINK);
                    }
                    else if (map[i][k] instanceof WallTile){
                        g.setColor(Color.BLACK);
                    }
                    else{
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
    public void drawShapes(int x, int y){

    }
}
