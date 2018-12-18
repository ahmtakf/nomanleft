package com.nullpointers.nomanleft.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;

public class ShopPanel {
    private final static int HIDE_PRICE = 50;
    private final static int DIG_PRICE = 50;
    private final static int FILL_PRICE = 50;
    private final static int MOVE_PRICE = 50;
    private JLabel gold;
    private JButton back;
    private JButton hideBButton;
    private JButton digBButton;
    private JButton fillBButton;
    private JButton moveBButton;
    private JLabel hideBLabel;
    private JLabel moveBLabel;
    private JLabel digBLabel;
    private JLabel fillBLabel;
    private JPanel itemPanel;
    private JPanel shopPanel;
    private JLabel hideBoosterPrice;
    private JLabel digBoosterPrice;
    private JLabel fillBoosterPrice;
    private JLabel MoveBoosterPrice;

    public JPanel getShopPanel() {
        return shopPanel;
    }



    public ShopPanel () {
        // set gold
        updateGold();

        hideBButton.setIcon(new ImageIcon(FileManager.getInstance().getBush()));
        digBButton.setIcon(new ImageIcon(FileManager.getInstance().getDigImage()));
        fillBButton.setIcon(new ImageIcon(FileManager.getInstance().getFillImage()));
        moveBButton.setIcon(new ImageIcon(FileManager.getInstance().getMoveImage()));

        hideBoosterPrice.setText(HIDE_PRICE+ "g");
        digBoosterPrice.setText(DIG_PRICE+ "g");
        fillBoosterPrice.setText(FILL_PRICE+ "g");
        MoveBoosterPrice.setText(MOVE_PRICE+ "g");

        back.setActionCommand("back");
        hideBButton.setActionCommand("hideBButton");
        digBButton.setActionCommand("digBButton");
        fillBButton.setActionCommand("fillBButton");
        moveBButton.setActionCommand("moveBButton");


        back.addActionListener(new ShopButtonListener());
        hideBButton.addActionListener(new ShopButtonListener());
        digBButton.addActionListener(new ShopButtonListener());
        fillBButton.addActionListener(new ShopButtonListener());
        moveBButton.addActionListener(new ShopButtonListener());



    }

    public void updateGold(){
        System.out.println("Update Gold");
        gold.setText("Gold: " + Integer.toString(FileManager.getInstance().getGold()));
    }




    private class ShopButtonListener implements ActionListener {

        public void actionPerformed (ActionEvent event) {
            String actionCommand = event.getActionCommand();
            switch (actionCommand){
                case "back": {GameManager.getInstance().openMainMenu();} break ;

                case "hideBButton": {System.out.println("buy hide");}  break;

                case "digBButton": {System.out.println("buy dig");} break;

                case "fillBButton": {System.out.println("buy fill");} break;

                case "moveBButton": {System.out.println("buy move");} break;


            }

        }

    }


}
