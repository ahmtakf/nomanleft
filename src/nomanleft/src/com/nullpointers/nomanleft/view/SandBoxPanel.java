package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;

import com.nullpointers.nomanleft.model.MapObject;
import com.nullpointers.nomanleft.model.Wall;
import com.nullpointers.nomanleft.model.WallTile;
import com.nullpointers.nomanleft.model.Wallable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class SandBoxPanel extends JPanel{


    private JPanel sandBoxPanel;
    private JButton back;
    private JPanel internalPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel requiredWallsLabel;
    private JButton saveButton;
    private JButton removeButton;
    private JRadioButton radioButton5;
    private int flag;

    public SandBoxPanel() {
        super();
        //setBackground(Color.BLUE);
        flag = 0;
        back.addActionListener(new SandBoxButtonListener());
        internalPanel.addMouseListener(new SandBoxMouseListener());
    }

    public JPanel getSandBoxPanel() {
        return sandBoxPanel;
    }

    private class SandBoxButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            switch (actionCommand) {
                case "Back": {
                    GameManager.getInstance().openMainMenu();
                }
                break;
                case "Peasent":{flag = 1; }break;
                case "Lava":{flag = 2;}break;
                case "Mountain":{flag = 3;}break;
                case "Tower":{flag = 4;}break;
                case "Soldier":{flag = 5;}break;
                case "Remove":{flag = 6;}break;
                case "Save":{}break;
            }
        }
    }

    private class SandBoxMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(flag == 1){
                //internalPanel
                flag = 0;
            }
            if (flag == 2){
                flag = 0;
            }
            if(flag == 3){
                flag = 0;
            }
            if(flag == 4){
                flag = 0;
            }
            if(flag == 5){
                flag = 0;
            }
            if(flag == 6){
                flag = 0;
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here


        button1 = new JButton();
        button1.setIcon(new ImageIcon(FileManager.getInstance().getFriendSoldier()));
        button2 = new JButton();
        button2.setIcon(new ImageIcon(FileManager.getInstance().getEnemySoldier()));
        button3 = new JButton();
        button3.setIcon(new ImageIcon(FileManager.getInstance().getTower()));
        button4 = new JButton();
        button4.setIcon(new ImageIcon(FileManager.getInstance().getMountain()));
        button5 = new JButton();
        button5.setIcon(new ImageIcon(FileManager.getInstance().getLava()));
        label1 =new JLabel();
        label1.setIcon(new ImageIcon(FileManager.getInstance().getWallPic1()));
        label2 =new JLabel();
        label2.setIcon(new ImageIcon(FileManager.getInstance().getWallPic2()));
        label3 =new JLabel();
        label3.setIcon(new ImageIcon(FileManager.getInstance().getWallPic3()));
        label4 =new JLabel();
        label4.setIcon(new ImageIcon(FileManager.getInstance().getWallPic4()));

        requiredWallsLabel = new JLabel();
        saveButton = new JButton();
        removeButton = new JButton();

        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        radioButton5 = new JRadioButton();
        internalPanel = new GameSandBoxPanel();
    }


}
