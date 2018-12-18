package com.nullpointers.nomanleft.model;
import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public abstract class Tile implements MapObject {
    public Point x;

    public Tile(){ }
    public abstract boolean isDiggable();
    public abstract boolean isFillable();

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

    @Override
    public Image getImage(){
        return FileManager.getInstance().getBush();
    }

}
