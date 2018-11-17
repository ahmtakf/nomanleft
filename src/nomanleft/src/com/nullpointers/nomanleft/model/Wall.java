package com.nullpointers.nomanleft.model;

public class Wall {

    private int[][] shape;

    public Wall(int[][] shape){
        this.shape = shape;

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

    public void rotateWall(){

    }

}
