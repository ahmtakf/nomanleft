package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

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

    @Override
    public Image getImage(){
        return FileManager.getInstance().getBush();
    }

}
