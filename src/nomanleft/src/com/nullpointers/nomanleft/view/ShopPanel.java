package com.nullpointers.nomanleft.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;

public class ShopPanel {
    private final static int HIDE_PRICE = 10;
    private final static int DIG_PRICE = 10;
    private final static int FILL_PRICE = 10;
    private final static int MOVE_PRICE = 10;
    private int goldAmount;
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
    private JLabel ownedHide;
    private JLabel ownedDig;
    private JLabel ownedFill;
    private JLabel ownedMove;

    public JPanel getShopPanel() {
        return shopPanel;
    }



    public ShopPanel () {
        // set gold
        updateLabels();

        hideBButton.setIcon(new ImageIcon(FileManager.getInstance().getBush()));
        digBButton.setIcon(new ImageIcon(FileManager.getInstance().getDigImage()));
        fillBButton.setIcon(new ImageIcon(FileManager.getInstance().getFillImage()));
        moveBButton.setIcon(new ImageIcon(FileManager.getInstance().getMoveImage()));

        hideBoosterPrice.setText(HIDE_PRICE+ "g");
        digBoosterPrice.setText(DIG_PRICE+ "g");
        fillBoosterPrice.setText(FILL_PRICE+ "g");
        MoveBoosterPrice.setText(MOVE_PRICE+ "g");

        ownedHide.setText(Integer.toString(FileManager.getInstance().getHideBooster()));
        ownedDig.setText(Integer.toString(FileManager.getInstance().getDigBooster()));
        ownedFill.setText(Integer.toString(FileManager.getInstance().getFillBooster()));
        ownedMove.setText(Integer.toString(FileManager.getInstance().getMoveBooster()));

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

    public void updateLabels(){
        goldAmount = FileManager.getInstance().getGold();
        gold.setText("Gold: " + goldAmount);
        ownedHide.setText("Owned: " + FileManager.getInstance().getHideBooster());
        ownedDig.setText ("Owned: " + FileManager.getInstance().getDigBooster());
        ownedFill.setText("Owned: " + FileManager.getInstance().getFillBooster());
        ownedMove.setText("Owned: " + FileManager.getInstance().getMoveBooster());
    }




    private class ShopButtonListener implements ActionListener {

        public void actionPerformed (ActionEvent event) {
            String actionCommand = event.getActionCommand();
            switch (actionCommand){
                case "back": {GameManager.getInstance().openMainMenu();} break ;

                case "hideBButton": {

                    if (goldAmount >= HIDE_PRICE){
                        FileManager.getInstance().setHideBooster(FileManager.getInstance().getHideBooster()+1);
                        goldAmount = goldAmount -HIDE_PRICE;
                        FileManager.getInstance().setGold(goldAmount);
                        updateLabels();
                    }
                    else
                        JOptionPane.showMessageDialog(shopPanel, "Not enough gold!");

                }  break;

                case "digBButton": {

                    if (goldAmount >= DIG_PRICE){
                    FileManager.getInstance().setDigBooster(FileManager.getInstance().getDigBooster()+1);
                    goldAmount = goldAmount -DIG_PRICE;
                    FileManager.getInstance().setGold(goldAmount);
                    updateLabels();
                }
                else
                    JOptionPane.showMessageDialog(shopPanel, "Not enough gold!");

                } break;

                case "fillBButton": {

                    if (goldAmount >= FILL_PRICE){
                    FileManager.getInstance().setFillBooster(FileManager.getInstance().getFillBooster()+1);
                    goldAmount = goldAmount -FILL_PRICE;
                    FileManager.getInstance().setGold(goldAmount);
                    updateLabels();
                }
                else
                    JOptionPane.showMessageDialog(shopPanel, "Not enough gold!");

                } break;

                case "moveBButton": {

                    if (goldAmount >= MOVE_PRICE){
                    FileManager.getInstance().setMoveBooster(FileManager.getInstance().getMoveBooster()+1);
                    goldAmount = goldAmount - MOVE_PRICE;
                    FileManager.getInstance().setGold(goldAmount);
                    updateLabels();
                }
                else
                    JOptionPane.showMessageDialog(shopPanel, "Not enough gold!");

                } break;

            }

        }

    }


}
