package com.nullpointers.nomanleft.model;

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
}
