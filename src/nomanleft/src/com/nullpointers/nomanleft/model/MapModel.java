package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapModel {

    private MapObject[][] map;
    private MapObjectFactory factory;
    private ArrayList<Wall> walls;
    private int[][] wallIdMap;

    public MapModel(int level){
        factory = new MapObjectFactory();
        map = new MapObject[8][8];
        walls = new ArrayList<>();
        wallIdMap = new int[8][8];

        for ( int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                wallIdMap[i][j] = 0;
            }
        }

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


        printMap();
        putWall(walls.get(0), 4,5 );
        printMap();
        printWallIDMap();

        takeWall(4,5);
        printMap();
        printWallIDMap();

    }

    public MapObject[][] getMap(){
        return map;
    }

    public void printWallIDMap(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(wallIdMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printMap(){

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print((map[i][j].getClass().hashCode()) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Wall> getWalls(){
        return walls;
    }

    public MapObject[][] takeWall(int x, int y){

        if (map[x][y] instanceof WallTile){
            int id = wallIdMap[x][y];
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++) {
                    if ((map[i][j] instanceof WallTile) && (id == wallIdMap[i][j])){
                        wallIdMap[i][j] = 0;
                        map[i][j] = factory.getMapObject("Ground");
                    }
                }
            }
        }

        return getMap();
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
                    wallIdMap[i+x-pivotX][j+y-pivotY] = wall.getId();
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
