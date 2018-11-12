package com.nullpointers.nomanleft;

import javax.swing.*;

public class GameManager {

    public void startLevel(int levelNumber){
        JFrame frame = new JFrame("LevelPanel");
        frame.setContentPane(new LevelPanel().LevelPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
