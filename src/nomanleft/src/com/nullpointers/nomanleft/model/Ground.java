package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public class Ground extends Tile {
    public Ground() {
        super();
    }

    @Override
    public boolean isDiggable() {
        return false;
    }

    @Override
    public boolean isFillable() {
        return false;
    }

    @Override
    public boolean isGround() {
        return true;
    }

    @Override
    public Image getImage(){
        return FileManager.getInstance().getGround();
    }

}
