package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapModel {

    private MapObject[][] map;
    private MapObjectFactory factory;
    private ArrayList<Wall> walls;
    private int[][] wallIdMap;
    private int[][] outsideMap;
    private int numberOfWallsOnMap;

    public MapModel(int level){
        factory = new MapObjectFactory();
        map = new MapObject[8][8];
        walls = new ArrayList<>();
        wallIdMap = new int[8][8];
        numberOfWallsOnMap = 0;

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
        printMap(wallIdMap);
    }

    public void printMap(){

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String name = map[i][j].getClass().getName();
                System.out.print((name.substring("com.nullpointers.nomanleft.model.".length(),name.length())) + " ");
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

        numberOfWallsOnMap++;


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (wallShape[i][j] > 0 && (universe[i+8+x-pivotX][j+8+y-pivotY] instanceof Ground)){
                    universe[i+8+x-pivotX][j+8+y-pivotY] = factory.getMapObject("WallTile");
                    wallIdMap[i+x-pivotX][j+y-pivotY] = numberOfWallsOnMap;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = universe[i+8][j+8];
            }
        }

        check();
        return getMap();
    }

    public boolean check(){

        //1 is outside, 0 is not outside
        outsideMap = new int[8][8];

        for (int m = 0; m < 8; m++){
            for(int k = 0; k < 8; k++){
                outsideMap[m][k] = 0;
            }
        }

        for (int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++) {
                if (map[i][j] instanceof Soldier && ((Soldier)map[i][j]).isEnemy()){
                    outsides(i,j);
                }
            }
        }

        printMap(outsideMap);

        for (int m = 0; m < 8; m++){
            for(int k = 0; k < 8; k++) {
                if (map[m][k] instanceof Soldier && !((Soldier)map[m][k]).isEnemy()){
                    if (outsideMap[m][k] == 1){
                        return false;
                    }
                }
                if (map[m][k] instanceof Tower){
                    if (outsideMap[m][k] == 1){
                        return false;
                    }
                }
                if (map[m][k] instanceof Soldier && ((Soldier)map[m][k]).isEnemy()){
                    if (outsideMap[m][k] == 0){
                        return false;
                    }
                }
            }
        }

        GameManager.getInstance().finishLevel();
        return true;
    }

    private void printMap(int[][] outsideMap) {
        for (int m = 0; m < 8; m++){
            for(int k = 0; k < 8; k++){
                System.out.print(outsideMap[m][k] + " ");
            }
            System.out.println();
        }
    }

    private void outsides(int x, int y){
        if ( x > 7 || x < 0 || y > 7 || y < 0){
            return;
        }
        if (map[x][y] instanceof  WallTile){
            return;
        }
        if (outsideMap[x][y] == 1){
            return;
        }
        outsideMap[x][y] = 1;
        outsides(x+1,y);
        outsides(x,y+1);
        outsides(x-1,y);
        outsides(x,y-1);
    }

}
