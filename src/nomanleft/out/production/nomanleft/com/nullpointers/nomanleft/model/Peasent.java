package nomanleft.out.production.nomanleft.com.nullpointers.nomanleft.model;

import java.awt.*;

public class Peasent extends Human {
    public Peasent(Point loc) {
        super(loc);
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
