package nomanleft.out.production.nomanleft.com.nullpointers.nomanleft.model;

import java.awt.*;

public class WallTile extends Tile {
    public WallTile(Point x) {
        super(x);
    }

    @Override
    public boolean isDiggable() {
        return false;
    }

    @Override
    public boolean isFilable() {
        return false;
    }
}
