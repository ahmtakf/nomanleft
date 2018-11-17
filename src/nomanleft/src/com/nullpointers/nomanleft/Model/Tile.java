package com.nullpointers.nomanleft.model;
import java.awt.*;

public abstract class Tile implements MapObject {
    protected Point x;

    public Tile(Point x){
        setPosition(x);
    }
    public abstract boolean isDiggable();
    public abstract boolean isFilable();

    @Override
    public void setPosition(Point obj) {
        this.x = obj;
    }

    @Override
    public Point getPoint() {
        return x;
    }

    @Override
    public boolean isGround() {
        return false;
    }
}
