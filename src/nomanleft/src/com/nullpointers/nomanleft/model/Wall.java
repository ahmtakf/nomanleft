package com.nullpointers.nomanleft.model;

import java.awt.*;

public class Wall {

    private int[][] shape;
    private int id;
    private final int MAP_SIZE = 13;
    private int[][] realX;
    private int[][] realY;

    public Wall(int[][] shape, int id){
        this.shape = shape;
        this.id = id;
        realX = new int[300][300];
        realY = new int[300][300];

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(shape[i][j]);
            }
            System.out.println();
        }

        real();
    }

    public int[][] getShape() {
        return shape;
    }

    public void setShape(int[][] shape) {
        this.shape = shape;
    }

    public int[][] rotateRight(){

        int[][] rightShape = new int[MAP_SIZE][MAP_SIZE];

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                rightShape[j][(MAP_SIZE-1-i)] = shape[i][j];
            }
        }

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                shape[i][j] = rightShape[i][j];
            }
        }

        real();
        return getShape();
    }


    public int[][] rotateLeft(){

        int[][] leftShape = new int[MAP_SIZE][MAP_SIZE];

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                leftShape[MAP_SIZE-1-j][i] = shape[i][j];
            }
        }


        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                shape[i][j] = leftShape[i][j];
            }
        }

        real();
        return getShape();
    }

    public void real(){

        int realStartX = 0;
        int realStartY = 0;
        int realEndX = MAP_SIZE;
        int realEndY = MAP_SIZE;

        for (int i = 0; i < 300; i++){
            for (int j = 0; j < 300; j++) {
                realX[i][j] = 0;
                realY[i][j] = 0;
            }
        }

        for (int i = 0; i < MAP_SIZE; i++){
            int j = 0;
            for(; j < MAP_SIZE; j++) {
                if (shape[i][j] > 0){
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
                if (shape[i][j] > 0){
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
                if (shape[i][j] > 0){
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
                if (shape[i][j] > 0){
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
                if ( realStartX % 2 == 0 && realStartY % 2 == 0) {
                    if (m % 2 == 0 && n % 2 == 0) {
                        for (int t = 0; t < 20; t++){
                            for (int h = 0; h < 20; h++) {
                                realX[(j / 2) * 120 + t][(i / 2) * 120 + h] = n;
                                realY[(j / 2) * 120 + t][(i / 2) * 120 + h] = m;
                            }
                        }
                    }
                    if (m % 2 == 1 && n % 2 == 0) {
                        for (int t = 0; t < 20; t++){
                            for (int h = 0; h < 100; h++) {
                                realX[(j / 2) * 120 + t][(i / 2) * 120 + 20 + h] = n;
                                realY[(j / 2) * 120 + t][(i / 2) * 120 + 20 + h] = m;
                            }
                        }

                    }
                    if (m % 2 == 0 && n % 2 == 1) {
                        for (int t = 0; t < 100; t++){
                            for (int h = 0; h < 20; h++) {
                                realX[(j / 2) * 120 + 20 + t][(i / 2) * 120 + h] = n;
                                realY[(j / 2) * 120 + 20 + t][(i / 2) * 120 + h] = m;
                            }
                        }

                    }
                    if (m % 2 == 1 && n % 2 == 1) {
                        for (int t = 0; t < 100; t++){
                            for (int h = 0; h < 100; h++) {
                                realX[(j / 2) * 120 + 20 + t][(i / 2) * 120 + 20 + h] = n;
                                realY[(j / 2) * 120 + 20 + t][(i / 2) * 120 + 20 + h] = m;
                            }
                        }
                    }
                }
                if ( realStartX % 2 == 0 && realStartY % 2 == 1) {
                    if (m % 2 == 0 && n % 2 == 1) {
                        for (int t = 0; t < 100; t++){
                            for (int h = 0; h < 20; h++) {
                                realX[(j / 2) * 120 + t][(i / 2) * 120 + h] = n;
                                realY[(j / 2) * 120 + t][(i / 2) * 120 + h] = m;
                            }
                        }
                    }
                    if (m % 2 == 0 && n % 2 == 0) {
                        for (int t = 0; t < 20; t++){
                            for (int h = 0; h < 20; h++) {
                                realX[(j / 2) * 120 + 100 +  t][(i / 2) * 120 + h] = n;
                                realY[(j / 2) * 120 + 100 +  t][(i / 2) * 120 + h] = m;
                            }
                        }
                    }
                    if (m % 2 == 1 && n % 2 == 0) {
                        for (int t = 0; t < 20; t++){
                            for (int h = 0; h < 100; h++) {
                                realX[(j / 2) * 120 + 100 + t][(i / 2) * 120 + 20 + h] = n;
                                realY[(j / 2) * 120 + 100 + t][(i / 2) * 120 + 20 + h] = m;
                            }
                        }
                    }
                    if (m % 2 == 1 && n % 2 == 1) {
                        for (int t = 0; t < 100; t++){
                            for (int h = 0; h < 100; h++) {
                                realX[(j / 2) * 120 + t][(i / 2) * 120 + 20 + h] = n;
                                realY[(j / 2) * 120 + t][(i / 2) * 120 + 20 + h] = m;
                            }
                        }
                    }
                }
                if ( realStartX % 2 == 1 && realStartY % 2 == 0) {
                    if (m % 2 == 1 && n % 2 == 0) {
                        for (int t = 0; t < 20; t++){
                            for (int h = 0; h < 100; h++) {
                                realX[(j / 2) * 120 + t][(i / 2) * 120 + h] = n;
                                realY[(j / 2) * 120 + t][(i / 2) * 120 + h] = m;
                            }
                        }
                    }
                    if (m % 2 == 0 && n % 2 == 1) {
                        for (int t = 0; t < 100; t++){
                            for (int h = 0; h < 20; h++) {
                                realX[(j / 2) * 120 + 20 + t][(i / 2) * 120 + 100 + h] = n;
                                realY[(j / 2) * 120 + 20 + t][(i / 2) * 120 + 100 + h] = m;
                            }
                        }
                    }
                    if (m % 2 == 0 && n % 2 == 0) {
                        for (int t = 0; t < 20; t++) {
                            for (int h = 0; h < 20; h++) {
                                realX[(j / 2) * 120 + t][(i / 2) * 120 + 100 + h] = n;
                                realY[(j / 2) * 120 + t][(i / 2) * 120 + 100 + h] = m;
                            }
                        }
                    }
                    if (m % 2 == 1 && n % 2 == 1) {
                        for (int t = 0; t < 100; t++){
                            for (int h = 0; h < 100; h++) {
                                realX[(j / 2) * 120 + 20 + t][(i / 2) * 120 + h] = n;
                                realY[(j / 2) * 120 + 20 + t][(i / 2) * 120 + h] = m;
                            }
                        }
                    }
                }
                if ( realStartX % 2 == 1 && realStartY % 2 == 1) {
                    if (m % 2 == 1 && n % 2 == 1) {
                        for (int t = 0; t < 100; t++){
                            for (int h = 0; h < 100; h++) {
                                realX[(j / 2) * 120 + t][(i / 2) * 120 + h] = n;
                                realY[(j / 2) * 120 + t][(i / 2) * 120 + h] = m;
                            }
                        }
                    }
                    if (m % 2 == 1 && n % 2 == 0) {
                        for (int t = 0; t < 20; t++){
                            for (int h = 0; h < 100; h++) {
                                realX[(j / 2) * 120 + 100 + t][(i / 2) * 120 + h] = n;
                                realY[(j / 2) * 120 + 100 + t][(i / 2) * 120 + h] = m;
                            }
                        }
                    }
                    if (m % 2 == 0 && n % 2 == 1) {
                        for (int t = 0; t < 100; t++){
                            for (int h = 0; h < 20; h++) {
                                realX[(j / 2) * 120 + t][(i / 2) * 120 + 100 + h] = n;
                                realY[(j / 2) * 120 + t][(i / 2) * 120 + 100 + h] = m;
                            }
                        }
                    }
                    if (m % 2 == 0 && n % 2 == 0) {
                        for (int t = 0; t < 20; t++){
                            for (int h = 0; h < 20; h++) {
                                realX[(j / 2) * 120 + 100 + t][(i / 2) * 120 + 100 + h] = n;
                                realY[(j / 2) * 120 + 100 + t][(i / 2) * 120 + 100 + h] = m;
                            }
                        }
                    }
                }
                j++;
            }
            i++;
        }

    }

    public int getRealX(int x, int y){
        return realY[x][y];
    }

    public int getRealY(int x, int y){
        return realX[x][y];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
