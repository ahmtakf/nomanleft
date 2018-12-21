package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

public class Fill implements Booster {

    public void use(MapObject[][] map, int x, int y) {
        if (((Tile) map[x][y]).isFillable()) {
            map[x][y] = MapObjectFactory.getInstance().getMapObject("Wallable");
            FileManager.getInstance().setFillBooster(FileManager.getInstance().getFillBooster()-1);
        }
        else
            System.out.println("Cannot Fill!");
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}

