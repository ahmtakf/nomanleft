package com.nullpointers.nomanleft.controller;

import com.nullpointers.nomanleft.model.BoosterMaker;
import com.nullpointers.nomanleft.model.MapModel;
import com.nullpointers.nomanleft.model.MapObjectFactory;
import com.nullpointers.nomanleft.view.*;

import javax.swing.*;
import java.awt.*;

public class GameManager {

    private final static GameManager instance = new GameManager();
    private final static int GOLD_REWARD = 10;
    private JFrame frame;
    private MapModel currentLevel;
    private MainMenuPanel mainMenuPanel;
    private PlayGamePanel playGamePanel;
    private ShopPanel shopPanel;
    private OptionsPanel optionsPanel;
    private LevelPanel levelPanel;
    private TimeTrial timeTrial;
    private BoosterMaker boosterMaker;
    private SandBoxPanel sandbox;
    private GameManager(){
        System.out.println(FileManager.getInstance().getCustomization());
        System.out.println(MapObjectFactory.getInstance());
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
        //optionsPanel = new OptionsPanel();
        boosterMaker = new BoosterMaker();
    }

    public void startLevel(int levelNumber){
        currentLevel = new MapModel(levelNumber);
        levelPanel = new LevelPanel();
        frame.setContentPane(levelPanel.getLevelPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void openTimeTrial () {
        timeTrial = new TimeTrial();
        timeTrial.startTimeTrial();
    }

    public void loadNextLevel () {
        LevelPanel nextLevel = timeTrial.changeLevel();

        if(nextLevel != null) {
            frame.setContentPane(nextLevel.getLevelPanel());
            frame.pack();
            frame.setVisible(true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        else {
            timeTrial.finished(false);
        }
    }

    public void finishTimeTrial () {
        timeTrial.finished(true);
    }


    public void changeCurrentLevel(int levelNumber) {
        System.out.println("level loaded: " + levelNumber);
        currentLevel = new MapModel(levelNumber);
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
        shopPanel.updateLabels();
        frame.setContentPane(shopPanel.getShopPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void openOptions() {
    /*
        frame.setContentPane(optionsPanel.getOptionsPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        */
    }

    public void openSandBox(){
        currentLevel = new MapModel(0);
        sandbox = new SandBoxPanel();
        frame.setContentPane(sandbox.getSandBoxPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void rewardGold (int levelsCompleted) {
        int goldGained = levelsCompleted*GOLD_REWARD;
        FileManager.getInstance().setGold(FileManager.getInstance().getGold()+ goldGained);
        JOptionPane.showMessageDialog(frame, "You have gained: " + goldGained + " gold!!");
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

    public void dig(int x, int y){
        boosterMaker.dig(currentLevel.getMap(),x,y);
    }
    public void fill(int x, int y){
        boosterMaker.fill(currentLevel.getMap(),x,y);
    }
    public void move(int x, int y, int direction){
        boosterMaker.move(currentLevel.getMap(),x,y,direction);
    }
    public void hide(int x, int y){
        boosterMaker.hide(currentLevel.getMap(),x,y);
    }
}
