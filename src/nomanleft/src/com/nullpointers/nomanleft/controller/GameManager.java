package com.nullpointers.nomanleft.controller;

import com.nullpointers.nomanleft.model.MapModel;
import com.nullpointers.nomanleft.view.*;


import javax.swing.*;
import java.awt.*;

public class GameManager {

    private final static GameManager instance = new GameManager();
    private JFrame frame;
    private MapModel currentLevel;
    private MainMenuPanel mainMenuPanel;
    private PlayGamePanel playGamePanel;
    private ShopPanel shopPanel;
    private OptionsPanel optionsPanel;

    private GameManager(){
        //System.out.println(FileManager.getInstance().getCustomization());
        frame = new JFrame("NoManLeft");
        frame.setPreferredSize(new Dimension(1600,800));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //initialize panel classes
        mainMenuPanel = new MainMenuPanel();
        playGamePanel = new PlayGamePanel();
        shopPanel = new ShopPanel();
        optionsPanel = new OptionsPanel();
    }

    public void startLevel(int levelNumber){
        currentLevel = new MapModel(levelNumber);
        frame.setContentPane(new LevelPanel().getLevelPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public static GameManager getInstance(){
        return instance;
    }

    public MapModel getMapModel() {
        return currentLevel;
    }

    public void openMainMenu () {
        frame.setContentPane(mainMenuPanel.getMainMenuPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public void openPlayGamePanel () {
        frame.setContentPane(playGamePanel.getPlayGamePanel());
        frame.pack();
        frame.setVisible(true);
    }

    public void openShop () {
        frame.setContentPane(shopPanel.getShopPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public void openOptions() {
        frame.setContentPane(optionsPanel.getOptionsPanel());
        frame.pack();
        frame.setVisible(true);

    }




}
