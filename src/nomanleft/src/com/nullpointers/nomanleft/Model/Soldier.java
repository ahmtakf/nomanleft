package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public class Soldier extends Human {

    public Soldier(boolean enemy) {
        super(enemy);
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
