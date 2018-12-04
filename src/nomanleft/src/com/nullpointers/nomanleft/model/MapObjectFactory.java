package com.nullpointers.nomanleft.model;

import java.util.HashMap;

public class MapObjectFactory {

    private static HashMap<String, MapObject> hm = new HashMap<>();

    public MapObject getMapObject(String type){
        MapObject object = null;

        if(hm.containsKey(type)){
            object = hm.get(type);
          //  System.out.println(type + " spoted!\n");
        }
        else {
            switch (type) {
                case "Tower":
                    object = new Tower();
                    System.out.println("Tower is created\n");
                    break;
                case "Wallable":
                    object = new Wallable();
                    System.out.println("Wallable is created\n");
                    break;
                case "Bush":
                    object = new Bush();
                    System.out.println("Bush is created\n");
                    break;
                case "Ground":
                    object = new Ground();
                    System.out.println("Ground is created\n");
                    break;
                case "WallTile":
                    object = new WallTile();
                    System.out.println("WallTile is created\n");
                    break;
                case "Mountain":
                    object = new Mountain();
                    System.out.println("Mountain is created\n");
                    break;
                case "Lava":
                    object = new Lava();
                    System.out.println("Lava is created\n");
                    break;
                case "BattleRam":
                    object = new BattleRam();
                    System.out.println("BattleRam is created\n");
                    break;
                case "EnemySoldier":
                    object = new Soldier(true);
                    System.out.println("Soldier is created\n");
                    break;
                case "FriendSoldier":
                    object = new Soldier(false);
                    System.out.println("Soldier is created\n");
                    break;
                case "Peasant":
                    object = new Peasant();
                    System.out.println("Peasant is created\n");
                    break;
            }
            hm.put(type, object);
        }

        return object;
    }

}
