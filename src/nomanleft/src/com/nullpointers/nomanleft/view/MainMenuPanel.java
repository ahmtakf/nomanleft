package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.GameManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.* ;

public class MainMenuPanel {

    private JButton playGame;
    private JButton timeTrial;
    private JButton sandbox;
    private JButton shop;
    private JButton howToPlay;
    private JButton options;
    private JButton credits;
    private JButton exit;
    private JLabel gameName;
    private JPanel buttonPanel;
    private JPanel mainMenuPanel;

    public JPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    //Constructor
    public MainMenuPanel(){
        playGame.setActionCommand("PlayGame");
        playGame.addActionListener(new MainMenuPanel.MenuButtonListener());

        timeTrial.setActionCommand("TimeTrial");
        timeTrial.addActionListener(new MenuButtonListener());

        sandbox.setActionCommand("SandBox");
        sandbox.addActionListener(new MenuButtonListener());

        shop.setActionCommand("Shop");
        shop.addActionListener(new MenuButtonListener());

        howToPlay.setActionCommand("HowToPlay");
        howToPlay.addActionListener(new MenuButtonListener());

        options.setActionCommand("Options");
        options.addActionListener(new MenuButtonListener());

        credits.setActionCommand("Credits");
        credits.addActionListener(new MenuButtonListener());

        exit.setActionCommand("Exit");
        exit.addActionListener(new MenuButtonListener());
    }


    public void playGame() {
        System.out.println("open PlayGamePanel");
        GameManager.getInstance().openPlayGamePanel();
    }

    public void openTimeTrial() {
        System.out.println("openTimeTrial ");
        GameManager.getInstance().openTimeTrial();
    }

    public void openSandBox() {
        System.out.println("openSandBox not yet");
    }

    public void openShop() {
        GameManager.getInstance().openShop();
    }

    public void openHowToPlay(){
        System.out.println("openHowToPlay not yet");
    }

    public void openCredits(){
        System.out.println("openCredits not yet");
    }

    public void openOptions(){
        GameManager.getInstance().openOptions();
    }

    public void quitGame(){
        System.out.println("quitGame");
    }



    //implement listeners

    private class MenuButtonListener implements ActionListener {

        public void actionPerformed (ActionEvent event) {
             String actionCommand = event.getActionCommand();
            switch (actionCommand) {
                case "PlayGame" :   playGame(); break;
                case "TimeTrial":   openTimeTrial() ; break ;
                case "SandBox":     openSandBox();  break ;
                case "Shop":        openShop(); break ;
                case "HowToPlay":   openHowToPlay(); break ;
                case "Credits":     openCredits(); break ;
                case "Options":     openOptions(); break;
                case "Exit":        quitGame(); break ;
            }
        }
    }


}
