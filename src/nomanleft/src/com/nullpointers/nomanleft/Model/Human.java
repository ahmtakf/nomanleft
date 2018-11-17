package com.nullpointers.nomanleft.model;

import java.awt.*;

public abstract class Human implements MapObject {

    protected boolean isEnemy;
    protected Point loc;
    public Human(Point loc ){
        this.isEnemy = false;
        setPosition(loc);
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
