package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public class Mountain extends Tile {
    public Mountain() {
        super();
    }

    @Override
    public boolean isDiggable() {
        return true;
    }

    @Override
    public boolean isFillable() {
        return false;
    }

    @Override
    public Image getImage(){
        return FileManager.getInstance().getMountain();
    }

}
