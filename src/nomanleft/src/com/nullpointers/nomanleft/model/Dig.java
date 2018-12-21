package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

public class Dig implements Booster {

    public void use(MapObject[][] map, int x, int y){
        if (((Tile)map[x][y]).isDiggable()) {
            map[x][y] = MapObjectFactory.getInstance().getMapObject("Wallable");
            FileManager.getInstance().setDigBooster(FileManager.getInstance().getDigBooster()-1);
        }
        else
            System.out.println("Cannot Dig!");
    }

    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public String getName() {
        return "Dig Booster";
    }
}
