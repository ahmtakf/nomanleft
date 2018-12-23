package com.nullpointers.nomanleft.model;

import com.nullpointers.nomanleft.controller.FileManager;

import java.awt.*;

public class Mountain extends Tile {
    boolean statement = false;
    public Mountain(boolean statement) {
        super();
        this.statement = statement;
    }

    @Override
    public boolean isDiggable() {
        return true;
    }

    @Override
    public boolean isFillable() {
        return false;
    }

    @Override
    public Image getImage(){
        if(statement)
            return FileManager.getInstance().getMountain();
        else
            return FileManager.getInstance().getLargeMountain();
    }

}
