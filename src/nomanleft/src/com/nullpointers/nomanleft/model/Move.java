package com.nullpointers.nomanleft.model;

public class Move implements Booster {



    public void use(MapObject[][] map, int x, int y, int newX, int newY){
        if (((Soldier)map[x][y]).isMovable() && map[newX][newY].isGround()) {
            map[newX][newY] = map[x][y];
            map[x][y] = MapObjectFactory.getInstance().getMapObject("Ground");
        }
        else
            System.out.println("Cannot Move there!");
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public String getName() {
        return "Move Booster";
    }
}
