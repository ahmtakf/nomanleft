package com.nullpointers.nomanleft.model;

public class BoosterMaker {

    private Hide hide;
    private Move move;
    private Dig dig;
    private Fill fill;


    public BoosterMaker(){

         hide = new Hide();
         move = new Move();
         dig = new Dig();
         fill = new Fill();
    }

    public void hide(MapObject[][] map, int x, int y){
        hide.use( map, x, y);
    }

    public void move(MapObject[][] map, int x, int y, int direction){
        move.use( map, x, y, direction);
    }

    public void dig(MapObject[][] map, int x, int y){
        dig.use( map, x, y);
    }

    public void fill(MapObject[][] map, int x, int y){
        fill.use( map, x, y);
    }

}
