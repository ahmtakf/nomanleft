package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public class Wallable extends Tile{

    public Wallable() {
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
    public Image getImage(){
        return FileManager.getInstance().getGround();
    }

}

