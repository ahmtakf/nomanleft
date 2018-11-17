package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public class Peasant extends Human {
    public Peasant() {
        super(false);
    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public boolean isHidable() {
        return true;
    }

    @Override
    public Image getImage(){
        return FileManager.getInstance().getBush();
    }

}
