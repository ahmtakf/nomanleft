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

public class PlayGamePanel extends JPanel {

    private static final int COL_NUMBER = 10;


    private ArrayList<JButton> levels;
    private JLabel title;
    private JButton backButton;
    private JPanel levelButtonPanel;

    public PlayGamePanel() {
        super();
        this.setPreferredSize(new Dimension(1600 ,900));
        setLayout(new GridBagLayout());

        levels = new ArrayList<JButton>();


        //DUMMY LEVELS ADDED UPDATE THIS*********
        for (int i = 0; i < 35 ; i++  ) {
            JButton tmp = new JButton("level: " + (i+1) );
            tmp.addActionListener(new ButtonListener());
            tmp.setActionCommand(Integer.toString(i));
            levels.add(tmp);
            System.out.println("addedTo ArrayList");
        }
        //***********

        int levelNumber = levels.size();
        int rowNo = levelNumber / COL_NUMBER + 1 ;

        //initialize levelButtonPanel, it will contain the level buttons
        levelButtonPanel = new JPanel(new GridLayout(rowNo,COL_NUMBER));

        //add the buttons to the panel
        for (int i = 0; i < levelNumber ; i++ ){
            levelButtonPanel.add(levels.get(i));
            System.out.println("addedTo LevelPanel");
        }

        // create the back button and label
        title = new JLabel ("<html><h><strong><i>Choose Level</i></strong></h></html>");
        backButton = new JButton("Back");

        // add title and backButton to the Top

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST ;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,0,300);
        add(backButton, gbc);

        gbc.anchor = GridBagConstraints.EAST ;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0,0,0,0);
        add(title, gbc);

        // add the level panel to CENTER
        gbc.anchor = GridBagConstraints.CENTER ;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        add(levelButtonPanel,gbc);


    }


    //implement listeners

    private class ButtonListener implements ActionListener {

        public void actionPerformed (ActionEvent event) {
            String actionCommand = event.getActionCommand();
            int i = Integer.parseInt(actionCommand);

            System.out.println("load level"+ i);

            GameManager.getInstance().startLevel(i);

        }

    }



}
