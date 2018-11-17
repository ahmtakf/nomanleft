package com.nullpointers.nomanleft.model;

import java.awt.*;

public class BattleRam extends Human{

    public BattleRam() {
        super(true);
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
