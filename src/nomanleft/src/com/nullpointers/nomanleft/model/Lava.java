package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public class Lava extends Tile {


    public Lava() {
        super();
    }

    @Override
    public boolean isDiggable() {
        return false;
    }

    @Override
    public boolean isFillable() {
        return true;
    }

    @Override
    public Image getImage(){
        return FileManager.getInstance().getLava();
    }

}
