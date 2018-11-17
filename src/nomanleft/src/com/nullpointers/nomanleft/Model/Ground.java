package com.nullpointers.nomanleft.model;

import java.awt.*;

public class Ground extends Tile {
    public Ground(Point x) {
        super(x);
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
