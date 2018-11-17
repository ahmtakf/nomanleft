package com.nullpointers.nomanleft.model;

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
}
