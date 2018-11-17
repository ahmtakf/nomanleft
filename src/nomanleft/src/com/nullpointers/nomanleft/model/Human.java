package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public abstract class Human implements MapObject {

    private boolean isEnemy;
    private Point loc;

    public Human(boolean isEnemy){
        this.isEnemy = isEnemy;
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

    public boolean isEnemy() {
        return isEnemy;
    }

    @Override
    public Image getImage(){
        return null;
    }

}
