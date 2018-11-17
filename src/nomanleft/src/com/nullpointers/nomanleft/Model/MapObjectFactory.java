package com.nullpointers.nomanleft.model;

import java.util.HashMap;
import java.util.Map;

public class MapObjectFactory {

    private static  HashMap<String, MapObject> hm = new HashMap<>();

    public MapObject getTile(Tile tile){
        MapObject tiles = null;

        if(hm.containsKey(tile)){
            tiles = hm.get(tile);
            System.out.println(tile.getClass().getSimpleName() + " spoted!\n");
        }
        else {
            String type = tile.getClass().getSimpleName();
            switch (type) {
                case "Tower":
                    tiles = new Tower(tile.getPoint());
                    System.out.println("Tower is created\n");
                    break;
                case "Bush":
                    tiles = new Bush(tile.getPoint());
                    System.out.println("Bush is created\n");
                    break;
                case "Ground":
                    tiles = new Ground(tile.getPoint());
                    System.out.println("Ground is created\n");
                    break;
                case "WallTile":
                    tiles = new WallTile(tile.getPoint());
                    System.out.println("WallTile is created\n");
                    break;
                case "Mountain":
                    tiles = new Mountain(tile.getPoint());
                    System.out.println("Mountain is created\n");
                    break;
                case "Lava":
                    tiles = new Lava(tile.getPoint());
                    System.out.println("Lava is created\n");
                    break;
            }
            hm.put(type, tile);
        }

        return tiles;
    }

    public MapObject getHuman(Human human){
        MapObject humans = null;
        if(hm.containsKey(human)){
            humans = hm.get(human);
            System.out.println(human.getClass().getSimpleName() + " spoted!\n");
        }
        else {
            String type = human.getClass().getSimpleName();
            switch (type) {
                case "BattleRam":
                    humans = new BattleRam(human.getPoint());
                    System.out.println("BattleRam is created\n");
                    break;
                case "Soldier":
                    humans = new Soldier(human.getPoint());
                    System.out.println("Soldier is created\n");
                    break;
                case "Peasent":
                    humans = new Peasent(human.getPoint());
                    System.out.println("Peasent is created\n");
                    break;
            }
            hm.put(type, humans);
        }
        return humans;
    }
}
