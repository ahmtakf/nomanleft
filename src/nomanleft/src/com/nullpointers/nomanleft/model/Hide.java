package com.nullpointers.nomanleft.model;

public class Hide implements Booster {

    public void use(MapObject[][] map, int x, int y){
        if (((Soldier)map[x][y]).isHidable())
            map[x][y] = MapObjectFactory.getInstance().getMapObject("Bush");
        else
            System.out.println("Cannot hide!");
    }

    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getName() {
        return "Hide Booster";
    }
}
