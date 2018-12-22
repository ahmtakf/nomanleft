package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomizationPanel {

    private int currentTheme;
    private JPanel customizationPanel;
    private JPanel set1;
    private JPanel set2;
    private JLabel bush1;
    private JLabel enemysoldier1;
    private JLabel fill1;
    private JLabel friendsoldier1;
    private JLabel ground1;
    private JLabel lava1;
    private JLabel mountain1;
    private JLabel move1;
    private JLabel pickaxe1;
    private JLabel tower1;
    private JLabel walltile1;
    private JLabel bush2;
    private JLabel enemysoldier2;
    private JLabel fill2;
    private JLabel friendsoldier2;
    private JLabel ground2;
    private JLabel lava2;
    private JLabel mountain2;
    private JLabel move2;
    private JLabel pickaxe2;
    private JLabel tower2;
    private JLabel walltile2;
    private JRadioButton set1RadioButton;
    private JRadioButton set2RadioButton;
    private ButtonGroup radioButtons;

    public CustomizationPanel() {
        radioButtons = new ButtonGroup();
        getCurrentTheme();

        if (currentTheme ==1)
            set1RadioButton.setSelected(true);
        else
            set2RadioButton.setSelected(true);


        set1RadioButton.setActionCommand("1");
        set2RadioButton.setActionCommand("2");

        ActionListener radios = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("1"))
                    changeTheme(1);
                else
                    changeTheme(2);

            }
        };

        set1RadioButton.addActionListener(radios);
        set2RadioButton.addActionListener(radios);
        radioButtons.add(set1RadioButton);
        radioButtons.add(set2RadioButton);



    }

    private void getCustomization() {
        if (currentTheme==1){
            bush1 = new JLabel(new ImageIcon( FileManager.getInstance().getBush()));
            enemysoldier1 = new JLabel(new ImageIcon( FileManager.getInstance().getEnemySoldier()));
            fill1 = new JLabel(new ImageIcon( FileManager.getInstance().getFillImage()));
            friendsoldier1 = new JLabel(new ImageIcon( FileManager.getInstance().getFriendSoldier()));
            ground1 = new JLabel(new ImageIcon( FileManager.getInstance().getGround()));
            lava1 = new JLabel(new ImageIcon( FileManager.getInstance().getLava()));
            mountain1 = new JLabel(new ImageIcon( FileManager.getInstance().getMountain()));
            move1 = new JLabel(new ImageIcon( FileManager.getInstance().getMoveImage()));
            pickaxe1 = new JLabel(new ImageIcon( FileManager.getInstance().getDigImage()));
            tower1 = new JLabel(new ImageIcon( FileManager.getInstance().getTower()));
            walltile1 = new JLabel(new ImageIcon( FileManager.getInstance().getWallTile()));
        }
        else {
            bush2 = new JLabel(new ImageIcon( FileManager.getInstance().getBush()));
            enemysoldier2 = new JLabel(new ImageIcon( FileManager.getInstance().getEnemySoldier()));
            fill2 = new JLabel(new ImageIcon( FileManager.getInstance().getFillImage()));
            friendsoldier2 = new JLabel(new ImageIcon( FileManager.getInstance().getFriendSoldier()));
            ground2 = new JLabel(new ImageIcon( FileManager.getInstance().getGround()));
            lava2 = new JLabel(new ImageIcon( FileManager.getInstance().getLava()));
            mountain2 = new JLabel(new ImageIcon( FileManager.getInstance().getMountain()));
            move2 = new JLabel(new ImageIcon( FileManager.getInstance().getMoveImage()));
            pickaxe2 = new JLabel(new ImageIcon( FileManager.getInstance().getDigImage()));
            tower2 = new JLabel(new ImageIcon( FileManager.getInstance().getTower()));
            walltile2 = new JLabel(new ImageIcon( FileManager.getInstance().getWallTile()));

        }
    }

    public JPanel getCustomizationPanel(){
        return customizationPanel;
    }

    public void getCurrentTheme() {
        currentTheme = FileManager.getInstance().getCustomization();
    }

    private void changeTheme(int setNo ) {
        System.out.println("setNo changed to : " + setNo +"\n");
        FileManager.getInstance().setCustomization(setNo);
        getCurrentTheme();
    }


    private void createUIComponents() {
        getCurrentTheme();
        if(currentTheme == 1)
        {
            getCustomization();
            changeTheme(2);
            getCustomization();
            changeTheme(1);

        }
        else {
            getCustomization();
            changeTheme(1);
            getCustomization();
            changeTheme(2);
        }


        set1 = new JPanel(new GridLayout(1,11));
        set2 = new JPanel(new GridLayout(1,11));

        set1.add(bush1);
        set1.add(enemysoldier1);
        set1.add(fill1);
        set1.add(friendsoldier1);
        set1.add(ground1);
        set1.add(lava1);
        set1.add(mountain1);
        set1.add(move1);
        set1.add(pickaxe1);
        set1.add(tower1);
        set1.add(walltile1);

        set2.add(bush2);
        set2.add(enemysoldier2);
        set2.add(fill2);
        set2.add(friendsoldier2);
        set2.add(ground2);
        set2.add(lava2);
        set2.add(mountain2);
        set2.add(move2);
        set2.add(pickaxe2);
        set2.add(tower2);
        set2.add(walltile2);



    }
}
