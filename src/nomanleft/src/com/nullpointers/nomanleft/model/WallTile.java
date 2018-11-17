package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public class WallTile extends Tile {
    public WallTile() {
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
        return FileManager.getInstance().getWallTile();
    }

}
