package com.nullpointers.nomanleft.model;

import java.awt.*;

public class Soldier extends Human {
    public Soldier() {
        super();
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public boolean isHidable() {
        return false;
    }
}
