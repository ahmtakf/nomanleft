package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public class Mountain extends Tile {
    public Mountain() {
        super();
    }

    @Override
    public boolean isDiggable() {
        return false;
    }

    @Override
    public boolean isFilable() {
        return false;
    }

    @Override
    public Image getImage(){
        return FileManager.getInstance().getMountain();
    }

}