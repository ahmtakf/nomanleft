package com.nullpointers.nomanleft.controller;

import com.nullpointers.nomanleft.model.MapModel;
import com.nullpointers.nomanleft.model.Wall;
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
    private LevelPanel levelPanel;

    private GameManager(){
        System.out.println(FileManager.getInstance().getCustomization());
        frame = new JFrame("NoManLeft");
        frame.setMinimumSize(new Dimension(1600,900));
        frame.setMaximumSize(new Dimension(1600,900));
        frame.setPreferredSize(new Dimension(1600,900));
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
        levelPanel = new LevelPanel();
        frame.setContentPane(levelPanel.getLevelPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void openPlayGamePanel () {
        frame.setContentPane(playGamePanel.getPlayGamePanel());
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void openShop () {
        frame.setContentPane(shopPanel.getShopPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void openOptions() {
        frame.setContentPane(optionsPanel.getOptionsPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public boolean check(){
        return getMapModel().check();
    }

    public boolean putWall (int wallId, int x, int y, int wallX, int wallY ) {
        return currentLevel.putWall(currentLevel.getWalls().get(wallId), x, y, wallX, wallY);
    }

    public void rotateWallOnPanelRight(int wallId){
        currentLevel.getWalls().get(wallId).rotateRight();
    }

    public void rotateWallOnPanelLeft(int wallId){
        currentLevel.getWalls().get(wallId).rotateLeft();
    }

}
