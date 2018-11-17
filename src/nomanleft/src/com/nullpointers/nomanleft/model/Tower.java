package com.nullpointers.nomanleft.model;

import java.awt.*;

public class Tower extends Tile{

    public Tower() {
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
