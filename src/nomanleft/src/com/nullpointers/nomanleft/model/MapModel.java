package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.view.LevelPanel;

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
    private final int MAP_SIZE = 13;

    public MapModel(int level){
        factory = new MapObjectFactory();
        map = new MapObject[MAP_SIZE][MAP_SIZE];
        walls = new ArrayList<>();
        wallIdMap = new int[MAP_SIZE][MAP_SIZE];
        numberOfWallsOnMap = 0;

        for ( int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                wallIdMap[i][j] = 0;
            }
        }

        BufferedReader br = FileManager.getInstance().getLevel(level);
        for ( int i = 0; i < MAP_SIZE; i++){
            if (i % 2 == 1){
                try {
                    String nodes = br.readLine();
                    int j = 0;
                    for (String nodeName: nodes.split(",")) {
                        map[i][j] = factory.getMapObject("Wallable");
                        j++;
                        map[i][j] = factory.getMapObject(nodeName);
                        j++;
                    }
                    map[i][j] = factory.getMapObject("Wallable");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                for (int j = 0; j < MAP_SIZE; j++) {
                    map[i][j] = factory.getMapObject("Wallable");
                }
            }
        }

        //Tower düzeltme

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] instanceof Tower) {
                    if (i + 2 < MAP_SIZE && (map[i + 2][j] instanceof Tower)) {
                        map[i + 1][j] = factory.getMapObject("Tower");
                    }
                    if (j + 2 < MAP_SIZE && (map[i][j + 2] instanceof Tower)) {
                        map[i][j+1] = factory.getMapObject("Tower");
                    }
                    if (i - 2 >= 0 && (map[i - 2][j] instanceof Tower)) {
                        map[i - 1][j] = factory.getMapObject("Tower");
                    }
                    if (j - 2 >= 0 && (map[i][j - 2] instanceof Tower)) {
                        map[i][j-1] = factory.getMapObject("Tower");
                    }
                    break;
                }
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

 /*
        printMap();
        putWall(walls.get(1), 6,7 );
        printMap();
        printWallIDMap();

       takeWall(4,5);
        printMap();
        printWallIDMap();*/

    }

    public MapObject[][] getMap(){
        return map;
    }

    public void printWallIDMap(){
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(wallIdMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printMap(){

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                String name = map[i][j].getClass().getName();
                System.out.print((name.substring("com.nullpointers.nomanleft.model.".length())) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Wall> getWalls(){
        return walls;
    }

    /*public MapObject[][] takeWall(int x, int y){

        if (map[x][y] instanceof WallTile){
            int id = wallIdMap[x][y];
            for (int i = 0; i < MAP_SIZE; i++){
                for (int j = 0; j < MAP_SIZE; j++) {
                    if ((map[i][j] instanceof WallTile) && (id == wallIdMap[i][j])){
                        wallIdMap[i][j] = 0;
                        map[i][j] = factory.getMapObject("Ground");
                    }
                }
            }
        }

        return getMap();
    }*/

    public MapObject[][] putWall(Wall wall, int x, int y){

        int[][] wallShape = wall.getShape();
        int pivotX = 0;
        int pivotY = 0;
        if ( x % 2 == 0 && y % 2 == 0) {
            System.out.println("Cannot put this wall there!clicked other tiles");
            return getMap();
        }
        if ( x % 2 == 1 && y % 2 == 1){
            System.out.println("Cannot put this wall there!clicked other tiles");
            return getMap();
        }


        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (wallShape[i][j] == 2){
                    pivotX = i;
                    pivotY = j;
                }
            }
        }

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (wallShape[i][j] > 0 && (i+x-pivotX < 0 || i+ x - pivotX >= MAP_SIZE  || j+y-pivotY < 0 || j+y-pivotY >= MAP_SIZE ||
                        !(map[i+x-pivotX][j+y-pivotY] instanceof Wallable))){
                    //raise error
                    System.out.println("Cannot put this wall there!");
                    return getMap();
                }
            }
        }

        numberOfWallsOnMap++;

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (wallShape[i][j] > 0 && (i+x-pivotX >= 0 && i+x-pivotX < MAP_SIZE && j+y-pivotY >= 0 && j+y-pivotY < MAP_SIZE &&
                        (map[i+x-pivotX][j+y-pivotY] instanceof Wallable))){
                    map[i+x-pivotX][j+y-pivotY] = factory.getMapObject("WallTile");
                    wallIdMap[i+x-pivotX][j+y-pivotY] = numberOfWallsOnMap;
                }
            }
        }

        for (int i = 0; i < MAP_SIZE; i = i+2) {
            for (int j = 0; j < MAP_SIZE; j = j+2) {
                int count = 0;
                if (i+1 < MAP_SIZE && (map[i+1][j] instanceof WallTile)){
                    count++;
                }
                if(j+1 < MAP_SIZE && (map[i][j+1] instanceof WallTile)){
                    count++;
                }
                if(i-1 >= 0 && (map[i-1][j] instanceof WallTile)){
                    count++;
                }
                if(j-1 >= 0 && (map[i][j-1] instanceof WallTile)){
                    count++;
                }
                if (count >= 2){
                    map[i][j] = factory.getMapObject("WallTile");
                }
            }
        }

        return getMap();
    }

    public boolean check(){

        //1 is outside, 0 is not outside
        outsideMap = new int[MAP_SIZE][MAP_SIZE];

        for (int m = 0; m < MAP_SIZE; m++){
            for(int k = 0; k < MAP_SIZE; k++){
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

        for (int m = 0; m < MAP_SIZE; m++){
            for(int k = 0; k < MAP_SIZE; k++) {
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

        return true;
    }

    private void printMap(int[][] outsideMap) {
        for (int m = 0; m < MAP_SIZE; m++){
            for(int k = 0; k < MAP_SIZE; k++){
                System.out.print(outsideMap[m][k] + " ");
            }
            System.out.println();
        }
    }

    private void outsides(int x, int y){
        if ( x > MAP_SIZE-1 || x < 0 || y > MAP_SIZE-1 || y < 0){
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
