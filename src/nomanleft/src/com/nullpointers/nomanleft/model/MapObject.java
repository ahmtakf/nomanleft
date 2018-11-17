package com.nullpointers.nomanleft.model;

import java.awt.*;

public interface MapObject {

    void setPosition(Point obj);
    Point getPoint();
    boolean isGround();
    Image getImage();

}
