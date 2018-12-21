package com.nullpointers.nomanleft.model;

public class Fill implements Booster {

    public void use(MapObject[][] map, int x, int y) {
        if (((Tile) map[x][y]).isFillable())
            map[x][y] = MapObjectFactory.getInstance().getMapObject("Wallable");
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

