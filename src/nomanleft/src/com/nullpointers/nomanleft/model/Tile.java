package com.nullpointers.nomanleft.model;
import java.awt.*;

public abstract class Tile implements MapObject {
    public Point x;

    public Tile(){ }
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
