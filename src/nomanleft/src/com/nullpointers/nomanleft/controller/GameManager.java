package com.nullpointers.nomanleft.controller;

import com.nullpointers.nomanleft.model.MapModel;
import com.nullpointers.nomanleft.view.LevelPanel;

import javax.swing.*;
import java.awt.*;

public class GameManager {

    private final static GameManager instance = new GameManager();
    private JFrame frame;

    private GameManager(){
        frame = new JFrame("NoManLeft");
        frame.setPreferredSize(new Dimension(1600,800));
        frame.setContentPane(new LevelPanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        System.out.println(FileManager.getInstance().getCustomization());
    }

    public void startLevel(int levelNumber){
        MapModel currentLevel = new MapModel(levelNumber);
        frame.setContentPane(new LevelPanel());
        frame.setVisible(true);
    }

    public static GameManager getInstance(){
        return instance;
    }


}
