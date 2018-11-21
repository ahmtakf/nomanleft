package com.nullpointers.nomanleft.model;

public class Wall {

    private int[][] shape;
    private int id;

    public Wall(int[][] shape, int id){
        this.shape = shape;
        this.id = id;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
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

        int[][] rightShape = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                rightShape[j][(7-i)] = shape[i][j];
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                shape[i][j] = rightShape[i][j];
            }
        }

        return getShape();
    }


    public int[][] rotateLeft(){

        int[][] leftShape = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                leftShape[7-j][i] = shape[i][j];
            }
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
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
