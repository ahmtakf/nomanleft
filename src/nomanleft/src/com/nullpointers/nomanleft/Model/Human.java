package com.nullpointers.nomanleft.model;

import java.awt.*;

public abstract class Human implements MapObject {

    public boolean isEnemy;
    public Point loc;

    public Human(){
        this.isEnemy = false;
    }

    public abstract boolean isMovable();
    public abstract boolean isHidable();


    @Override
    public void setPosition(Point obj) {
        this.loc = obj;
    }

    @Override
    public Point getPoint() {
        return loc;
    }

    @Override
    public boolean isGround() {
        return false;
    }

}
