package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapModel {

    private MapObject[][] map;
    private MapObjectFactory factory;
    private ArrayList<Wall> walls;

    public MapModel(int level){
        factory = new MapObjectFactory();
        map = new MapObject[8][8];
        walls = new ArrayList<>();
        BufferedReader br = FileManager.getInstance().getLevel(level);

        for ( int i = 0; i < 8; i++){
            try {
                String nodes = br.readLine();
                int j = 0;
                for (String nodeName: nodes.split(",")) {
                    map[i][j] = factory.getMapObject(nodeName);
                    j++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            String wallIds = br.readLine();
            for(String id: wallIds.split(",")){
                walls.add(FileManager.getInstance().getWalls().get(Integer.parseInt(id) - 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


       /* printMap();
        putWall(walls.get(0), 4,5 );*/
        printMap();

    }

    public MapObject[][] getMap(){
        return map;
    }

    public void printMap(){

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print((map[i][j].getClass().hashCode() - 2005169944) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Wall> getWalls(){
        return walls;
    }

    public MapObject[][] putWall(Wall wall, int x, int y){

        MapObject[][] universe = new MapObject[24][24];
        int[][] wallShape = wall.getShape();
        int pivotX = 0;
        int pivotY = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                universe[i+8][j+8] = map[i][j];
                if (wallShape[i][j] == 2){
                    pivotX = i;
                    pivotY = j;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (wallShape[i][j] > 0 && !(universe[i+8+x-pivotX][j+8+y-pivotY] instanceof Ground)){
                    //raise error
                    System.out.println("Cannot put this wall there!");
                    return getMap();
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (wallShape[i][j] > 0 && (universe[i+8+x-pivotX][j+8+y-pivotY] instanceof Ground)){
                    universe[i+8+x-pivotX][j+8+y-pivotY] = factory.getMapObject("WallTile");
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = universe[i+8][j+8];
            }
        }

        return getMap();
    }


}
