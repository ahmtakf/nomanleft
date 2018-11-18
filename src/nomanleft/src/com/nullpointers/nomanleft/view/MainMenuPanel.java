package com.nullpointers.nomanleft.view;

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
        playGame.setActionCommand("TimeTrial");
        playGame.addActionListener(new ButtonListener());

        timeTrial.setActionCommand("TimeTrial");
        timeTrial.addActionListener(new ButtonListener());

        sandbox.setActionCommand("SandBox");
        sandbox.addActionListener(new ButtonListener());

        shop.setActionCommand("Shop");
        shop.addActionListener(new ButtonListener());

        howToPlay.setActionCommand("HowToPlay");
        howToPlay.addActionListener(new ButtonListener());

        options.setActionCommand("Options");
        options.addActionListener(new ButtonListener());

        credits.setActionCommand("Credits");
        credits.addActionListener(new ButtonListener());

        exit.setActionCommand("Exit");
        exit.addActionListener(new ButtonListener());
    }


    public void playGame() {
        System.out.println("PlayGame");
    }

    public void openTimeTrial() {
        System.out.println("openTimeTrial");
    }

    public void openSandBox() {
        System.out.println("openSandBox");
    }

    public void openShop() {
        System.out.println("openShop");
    }

    public void openHowToPlay(){
        System.out.println("openHowToPlay");
    }

    public void openCredits(){
        System.out.println("openCredits");
    }

    public void openOptions(){
        System.out.println("openOptions");
    }

    public void quitGame(){
        System.out.println("quitGame");
    }



    //implement listeners

    private class ButtonListener implements ActionListener {

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
