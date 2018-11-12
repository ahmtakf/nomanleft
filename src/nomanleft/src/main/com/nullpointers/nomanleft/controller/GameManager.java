package main.com.nullpointers.nomanleft.controller;

import main.img.nullpointers.nomanleft.view.LevelPanel;

import javax.swing.*;

public class GameManager {

    public GameManager(){
        System.out.println(FileManager.getInstance().getCustomization());
    }

    public void startLevel(int levelNumber){
        JFrame frame = new JFrame("LevelPanel");
        frame.setContentPane(new LevelPanel().LevelPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
