package nomanleft.out.production.nomanleft.com.nullpointers.nomanleft.model;

import java.awt.*;

public class BattleRam extends Human{

    public BattleRam(Point loc) {
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
