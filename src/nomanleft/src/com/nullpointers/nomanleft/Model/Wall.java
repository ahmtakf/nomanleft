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

    public int[][] rotateRight(){

        int[][] rightShape = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                rightShape[j][(7-i)] = shape[i][j];
            }
        }

      /*  for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(shape[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                shape[i][j] = rightShape[i][j];
                System.out.print(shape[i][j]);
            }
            System.out.println();
        }*/


        return getShape();
    }


    public int[][] rotateLeft(){

        int[][] leftShape = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                leftShape[7-j][i] = shape[i][j];
            }
        }

      /*  for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(shape[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                shape[i][j] = leftShape[i][j];
                System.out.print(shape[i][j]);
            }
            System.out.println();
        }*/


        return getShape();
    }

}
