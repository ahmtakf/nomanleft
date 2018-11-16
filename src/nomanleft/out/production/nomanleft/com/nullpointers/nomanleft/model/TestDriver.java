package nomanleft.out.production.nomanleft.com.nullpointers.nomanleft.model;

import java.awt.*;

public class TestDriver {
    public static void main (String[] args){
        System.out.println("Hellooo");
        Point x = new Point();
        Tile tile = new Tower(x);
        Tower y = new Tower(x);
        System.out.println((y.getClass().getSimpleName()));
    }
}
