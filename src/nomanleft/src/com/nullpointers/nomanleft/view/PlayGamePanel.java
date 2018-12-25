package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.FileManager;
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
        int availableLevelNo = FileManager.getInstance().getNumberOfNormalLevels();
        int availableLevelSandbox = FileManager.getInstance().getNumberOfSandboxLevels();


        levelsList = new ArrayList<>();

        for (int i = 0; i < availableLevelNo ; i++  ) {
            JButton tmp = new JButton("Normal level: " + (i+1) );
            tmp.addActionListener(new PlayGamePanel.PButtonListener());
            tmp.setActionCommand(Integer.toString(i+1));
            levelsList.add(tmp);
        }

        for (int i = 0; i < availableLevelSandbox ; i++  ) {
            JButton tmp = new JButton("Sandbox level: " + (i+1) );
            tmp.addActionListener(new PlayGamePanel.PButtonListener());
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
                if (! ((JButton)event.getSource()).getText().substring(0, 7).equals("Sandbox")) {
                    System.out.println("load normal level" + i);
                    GameManager.getInstance().startNormalLevel(i);
                }
                else{
                    System.out.println("load sandbox level" + ((JButton)event.getSource()).getText().charAt(((JButton)event.getSource()).getText().length() - 1));
                    GameManager.getInstance().startSandBoxLevel(((JButton)event.getSource()).getText().charAt(((JButton)event.getSource()).getText().length() - 1) - '0');
                }
            }
        }

    }



}
