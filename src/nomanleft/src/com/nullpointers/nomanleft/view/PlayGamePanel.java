package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.GameManager;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.* ;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument;

public class PlayGamePanel {

    private static final int COL_NUMBER = 10;

    private ArrayList<JButton> levelsList;
    private JPanel playGamePanel;
    private JButton backButton;
    private JLabel title;
    private JPanel topPanel;
    private JPanel levelPanel;



    public JPanel getPlayGamePanel() {
        return playGamePanel;
    }


    public PlayGamePanel() {

        // get availableLevelNo from file manager when implemented
        int availableLevelNo = 20;


        levelsList = new ArrayList<>();


        for (int i = 0; i < availableLevelNo ; i++  ) {
            JButton tmp = new JButton("level: " + (i+1) );
            tmp.addActionListener(new PButtonListener());
            tmp.setActionCommand(Integer.toString(i+1));
            levelsList.add(tmp);
        }


        //calculate the dimensions
        int levelNumber = levelsList.size();
        int rowNumber = levelNumber / COL_NUMBER ;

        levelPanel.setLayout(new GridLayout(rowNumber,COL_NUMBER,10,10));

        for (int i = 0; i < levelNumber ; i++  )
            levelPanel.add(levelsList.get(i));


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().openMainMenu();
            }
        });
    }


    private void createUIComponents() {
        levelPanel = new JPanel();
    }


    //implement listeners

    private class PButtonListener implements ActionListener {

        public void actionPerformed (ActionEvent event) {
            String actionCommand = event.getActionCommand();
            int i = Integer.parseInt(actionCommand);


            if ( i >= 0 && i< levelsList.size()){
                System.out.println("load level" + i);
                GameManager.getInstance().startLevel(i);
            }
        }

    }



}
