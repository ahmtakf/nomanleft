package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;

import com.nullpointers.nomanleft.model.MapObject;
import com.nullpointers.nomanleft.model.Wall;
import com.nullpointers.nomanleft.model.WallTile;
import com.nullpointers.nomanleft.model.Wallable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JRadioButton radioButton5;


    public SandBoxPanel() {
        super();
        //setBackground(Color.BLUE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GameManager.getInstance().openMainMenu();
            }
        });



    }

    public JPanel getSandBoxPanel() {
        return sandBoxPanel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        internalPanel = new GameSandBoxPanel();
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
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        radioButton5 = new JRadioButton();
    }


}
