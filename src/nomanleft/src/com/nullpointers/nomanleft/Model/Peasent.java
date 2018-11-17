package com.nullpointers.nomanleft.model;

import java.awt.*;

public class Peasent extends Human {
    public Peasent() {
        super();
    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public boolean isHidable() {
        return true;
    }
}
