package com.nullpointers.nomanleft.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.* ;
import javax.swing.border.EmptyBorder;

public class MainMenuPanel extends JPanel{

    private Dimension buttonSpace = new Dimension(1,50);
    private JPanel  buttonContainer;
    private JButton playGame;
    private JButton timeTrial;
    private JButton sandbox;
    private JButton shop;
    private JButton howToPlay;
    private JButton options;
    private JButton credits;
    private JButton exit;
    private JLabel gameName;

    //Constructor
    public MainMenuPanel(){
        super();
        setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setPreferredSize(new Dimension(1600 ,900));

    //initialize buttons, set action commands; add boarders, listeners

        EmptyBorder buttonBorder =  new EmptyBorder(10, 20, 10, 20);

        playGame = new JButton("PlayGame");
        playGame.setBorder(buttonBorder);
        playGame.setActionCommand("PlayGame");
        playGame.addActionListener(new ButtonListener());

        timeTrial = new JButton("TimeTrial");
        timeTrial.setBorder(buttonBorder);
        timeTrial.setActionCommand("TimeTrial");
        timeTrial.addActionListener(new ButtonListener());

        sandbox = new JButton("SandBox");
        sandbox.setBorder(buttonBorder);
        sandbox.setActionCommand("SandBox");
        sandbox.addActionListener(new ButtonListener());

        shop = new JButton("Shop");
        shop.setBorder(buttonBorder);
        shop.setActionCommand("Shop");
        shop.addActionListener(new ButtonListener());

        howToPlay = new JButton("HowToPlay");
        howToPlay.setBorder(buttonBorder);
        howToPlay.setActionCommand("HowToPlay");
        howToPlay.addActionListener(new ButtonListener());

        options = new JButton ("Options");
        options.setBorder(buttonBorder);
        options.setActionCommand("Options");
        options.addActionListener(new ButtonListener());

        credits = new JButton ("Credits");
        credits.setBorder(buttonBorder);
        credits.setActionCommand("Credits");
        credits.addActionListener(new ButtonListener());

        exit = new JButton("Exit");
        exit.setBorder(buttonBorder);
        exit.setActionCommand("Exit");
        exit.addActionListener(new ButtonListener());

    //initialize Label
        gameName = new JLabel ("<html><h1><strong><i>NoManLeft</i></strong></h1></html>");

    //initialize GridBagConstraints
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

    //add the label to panel
        add(gameName, gbc);

    //update constraints
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

    //add the buttons to a subPanel
        buttonContainer = new JPanel(new GridBagLayout());

        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(playGame,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(timeTrial,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(sandbox,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(shop,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(howToPlay,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(options,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(credits,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(exit,gbc);
    //add the panel to this panel
        gbc.weighty = 1;
        add(buttonContainer, gbc);



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
