package nomanleft.out.production.nomanleft.com.nullpointers.nomanleft.model;

import java.awt.*;

public class Soldier extends Human {
    public Soldier(Point loc) {
        super(loc);
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
