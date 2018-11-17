package com.nullpointers.nomanleft.model;

import java.awt.*;

public class Lava extends Tile {


    public Lava(Point x) {
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
