package com.nullpointers.nomanleft.controller;

import com.nullpointers.nomanleft.model.MapModel;
import com.nullpointers.nomanleft.view.LevelPanel;

import javax.swing.*;
import java.awt.*;

public class GameManager {

    private final static GameManager instance = new GameManager();
    private JFrame frame;
    private MapModel currentLevel;

    private GameManager(){
        System.out.println(FileManager.getInstance().getCustomization());
    }

    public void startLevel(int levelNumber){
        currentLevel = new MapModel(levelNumber);
        frame = new JFrame("NoManLeft");
        frame.setPreferredSize(new Dimension(1600,800));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new LevelPanel().levelPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static GameManager getInstance(){
        return instance;
    }

    public MapModel getMapModel() {
        return currentLevel;
    }
}
