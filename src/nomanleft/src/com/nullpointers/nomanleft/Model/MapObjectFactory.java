package com.nullpointers.nomanleft.model;

import java.util.HashMap;
import java.util.Map;

public class MapObjectFactory {

    private static HashMap<String, MapObject> hm = new HashMap<>();

    public MapObject getTile(String type){
        MapObject tiles = null;

        if(hm.containsKey(type)){
            tiles = hm.get(type);
            System.out.println(type + " spoted!\n");
        }
        else {
            switch (type) {
                case "Tower":
                    tiles = new Tower();
                    System.out.println("Tower is created\n");
                    break;
                case "Bush":
                    tiles = new Bush();
                    System.out.println("Bush is created\n");
                    break;
                case "Ground":
                    tiles = new Ground();
                    System.out.println("Ground is created\n");
                    break;
                case "WallTile":
                    tiles = new WallTile();
                    System.out.println("WallTile is created\n");
                    break;
                case "Mountain":
                    tiles = new Mountain();
                    System.out.println("Mountain is created\n");
                    break;
                case "Lava":
                    tiles = new Lava();
                    System.out.println("Lava is created\n");
                    break;
            }
            hm.put(type, tiles);
        }

        return tiles;
    }

    public MapObject getHuman(String type){
        MapObject humans = null;
        if(hm.containsKey(type)){
            humans = hm.get(type);
            System.out.println(type + " spoted!\n");
        }
        else {
            switch (type) {
                case "BattleRam":
                    humans = new BattleRam();
                    System.out.println("BattleRam is created\n");
                    break;
                case "Soldier":
                    humans = new Soldier();
                    System.out.println("Soldier is created\n");
                    break;
                case "Peasent":
                    humans = new Peasent();
                    System.out.println("Peasent is created\n");
                    break;
            }
            hm.put(type, humans);
        }
        return humans;
    }
}
