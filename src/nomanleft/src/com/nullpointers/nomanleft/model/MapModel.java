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
                    map[i][j] = factory.getObject(nodeName);
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

    }

    public MapObject[][] getMap(){
        return map;
    }

}
