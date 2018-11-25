package com.nullpointers.nomanleft.model;

public class Wall {

    private int[][] shape;
    private int id;
    private final int MAP_SIZE = 13;

    public Wall(int[][] shape, int id){
        this.shape = shape;
        this.id = id;

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(shape[i][j]);
            }
            System.out.println();
        }

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

        return getShape();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
