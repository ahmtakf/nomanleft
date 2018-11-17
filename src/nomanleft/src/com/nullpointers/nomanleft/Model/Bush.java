package com.nullpointers.nomanleft.model;

import java.awt.*;

public class Bush extends Tile{
    public Bush(Point x) {
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
