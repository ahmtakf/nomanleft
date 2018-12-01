package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.GameManager;
import com.nullpointers.nomanleft.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private MapObject[][] map;
    private final int MAP_SIZE = 13;
    private int[][] wallShape;
    private int[] wallPositionX;
    private int[] wallPositionY;
    private ArrayList<Wall> walls = GameManager.getInstance().getMapModel().getWalls();

    public GamePanel() {
        super();
        wallPositionX = new int[walls.size()];
        wallPositionY = new int[walls.size()];
        for (int i = 0; i < wallPositionX.length; i++){
            wallPositionX[i] = 800 + 300 * (i/2);
            wallPositionY[i] = 50 + (i % 2) * 300;
        }

        map = GameManager.getInstance().getMapModel().getMap();
        repaint();
        validate();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        this.setBackground(Color.WHITE);

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

        for (int k = 0; k < walls.size(); k++) {
            wallShape = walls.get(k).getShape();
            drawWalls(g, k);
        }
    }

    void drawWalls(Graphics g, int k){

        int realStartX = 0;
        int realStartY = 0;
        int realEndX = MAP_SIZE;
        int realEndY = MAP_SIZE;

        for (int i = 0; i < MAP_SIZE; i++){
            int j = 0;
            for(; j < MAP_SIZE; j++) {
                if (wallShape[i][j] > 0){
                    break;
                }
            }
            if ( j != MAP_SIZE){
                break;
            }
            realStartX++;
        }

        for(int j = 0; j < MAP_SIZE; j++) {
            int i = 0;
            for (; i < MAP_SIZE; i++){
                if (wallShape[i][j] > 0){
                    break;
                }
            }
            if ( i != MAP_SIZE){
                break;
            }
            realStartY++;
        }

        for (int i = MAP_SIZE - 1; i >= 0; i--){
            int j = 0;
            for(; j < MAP_SIZE; j++) {
                if (wallShape[i][j] > 0){
                    break;
                }
            }
            if ( j != MAP_SIZE){
                break;
            }
            realEndX--;
        }

        for (int j = MAP_SIZE - 1; j >= 0; j--){
            int i = 0;
            for (; i < MAP_SIZE; i++){
                if (wallShape[i][j] > 0){
                    break;
                }
            }
            if ( i != MAP_SIZE){
                break;
            }
            realEndY--;
        }

        int i = 0;
        for (int m = realStartX; m < realEndX; m++){
            int j = 0;
            for(int n = realStartY; n < realEndY; n++){
                g.setColor(Color.WHITE);
                if (wallShape[m][n] > 0){
                    g.setColor(Color.BLACK);
                }
                if ( realStartX % 2 == 0 && realStartY % 2 == 0) {
                    if (m % 2 == 0 && n % 2 == 0) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120, wallPositionY[k] + (i / 2) * 120, 20, 20);
                    }
                    if (m % 2 == 1 && n % 2 == 0) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120, wallPositionY[k] + (i / 2) * 120 + 20, 20, 100);
                    }
                    if (m % 2 == 0 && n % 2 == 1) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120 + 20, wallPositionY[k] + (i / 2) * 120, 100, 20);
                    }
                    if (m % 2 == 1 && n % 2 == 1) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120 + 20, wallPositionY[k] + (i / 2) * 120 + 20, 100, 100);
                    }
                }
                if ( realStartX % 2 == 0 && realStartY % 2 == 1) {
                    if (m % 2 == 0 && n % 2 == 1) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120, wallPositionY[k] + (i / 2) * 120, 100, 20);
                    }
                    if (m % 2 == 0 && n % 2 == 0) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120 + 100, wallPositionY[k] + (i / 2) * 120, 20, 20);
                    }
                    if (m % 2 == 1 && n % 2 == 0) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120 + 100, wallPositionY[k] + (i / 2) * 120 + 20, 20, 100);
                    }
                    if (m % 2 == 1 && n % 2 == 1) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120, wallPositionY[k] + (i / 2) * 120 + 20, 100, 100);
                    }
                }
                if ( realStartX % 2 == 1 && realStartY % 2 == 0) {
                    if (m % 2 == 1 && n % 2 == 0) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120, wallPositionY[k] + (i / 2) * 120, 20, 100);
                    }
                    if (m % 2 == 0 && n % 2 == 1) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120 + 20, wallPositionY[k] + (i / 2) * 120 + 100, 100, 20);
                    }
                    if (m % 2 == 0 && n % 2 == 0) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120, wallPositionY[k] + (i / 2) * 120 + 100, 20, 20);
                    }
                    if (m % 2 == 1 && n % 2 == 1) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120 + 20, wallPositionY[k] + (i / 2) * 120, 100, 100);
                    }
                }
                if ( realStartX % 2 == 1 && realStartY % 2 == 1) {
                    if (m % 2 == 1 && n % 2 == 1) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120, wallPositionY[k] + (i / 2) * 120, 100, 100);
                    }
                    if (m % 2 == 1 && n % 2 == 0) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120 + 100, wallPositionY[k] + (i / 2) * 120, 20, 100);
                    }
                    if (m % 2 == 0 && n % 2 == 1) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120, wallPositionY[k] + (i / 2) * 120 + 100, 100, 20);
                    }
                    if (m % 2 == 0 && n % 2 == 0) {
                        g.fillRect(wallPositionX[k] + (j / 2) * 120 + 100, wallPositionY[k] + (i / 2) * 120 + 100, 20, 20);
                    }
                }
                j++;
            }
            i++;
        }

    }

    public void setWallPositionX(int x[]){
        wallPositionX = x;
    }
    public void setWallPositionY(int y[]){
        wallPositionY = y;
    }
    public int[] getWallPositionX(){
        return wallPositionX;
    }
    public int[] getWallPositionY(){
        return wallPositionY;
    }
}
