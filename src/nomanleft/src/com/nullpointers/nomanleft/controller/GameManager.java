package com.nullpointers.nomanleft.controller;

import com.nullpointers.nomanleft.view.LevelPanel;

import javax.swing.*;

public class GameManager {

    private final static GameManager instance = new GameManager();

    private GameManager(){
        System.out.println(FileManager.getInstance().getCustomization());
    }

    public void startLevel(int levelNumber){
        JFrame frame = new JFrame("LevelPanel");
        frame.setContentPane(new LevelPanel().LevelPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static GameManager getInstance(){
        return instance;
    }


}
