package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

public class Move implements Booster {



    public void use(MapObject[][] map, int x, int y, int direction){
        int a = 0;
        int b = 0;
        switch (direction){
            case 0://left
                a = 0;
                b = -2;
                break;
            case 1://right
                a = 0;
                b = 2;
                break;
            case 2://up
                a = -2;
                b = 0;
                break;
            case 3://down
                a = 2;
                b = 0;
                break;
        }
        if (((Soldier)map[x][y]).isMovable() && map[x+a][y+b].isGround()) {
            map[x+a][y+b] = map[x][y];
            map[x][y] = MapObjectFactory.getInstance().getMapObject("Ground");
            FileManager.getInstance().setMoveBooster(FileManager.getInstance().getMoveBooster()-1);
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
