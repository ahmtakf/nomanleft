package com.nullpointers.nomanleft.model;

public class Dig implements Booster {

    public void use(MapObject[][] map, int x, int y){
        if (((Tile)map[x][y]).isDiggable())
            map[x][y] = MapObjectFactory.getInstance().getMapObject("Wallable");
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
