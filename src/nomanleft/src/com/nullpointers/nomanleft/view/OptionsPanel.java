package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class OptionsPanel {

    private static Mixer mixer ;
    private static Clip clip;
    private FloatControl volumeControl;
    private BooleanControl muteControl;
    private JCheckBox mute;
    private JSlider volumeBar;
    private JLabel volumeLabel;
    private JButton backButton;
    private JPanel topPanel;
    private JPanel optionsPanel;
    private JPanel customPanel;
    private float max,min;
    private CustomizationPanel customizationPanel;

    private int volume;
    private int oldVolume;

    public JPanel getOptionsPanel() {
        return optionsPanel;
    }

    public OptionsPanel() {

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GameManager.getInstance().openMainMenu();
            }
        });


        mute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileManager.getInstance().changeSound();
                muteControl.setValue(FileManager.getInstance().getSound()== 0);
                if (FileManager.getInstance().getSound()== 1)
                    playMusic();
            }
        });

        mute.setSelected(FileManager.getInstance().getSound() == 0 );
        volumeBar.setValue(FileManager.getInstance().getSoundLevel());



        volumeBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider temp = (JSlider)e.getSource();
                FileManager.getInstance().setSoundLevel(temp.getValue());
                adjustVolume();
            }
        });

        setClip();
        adjustVolume();
        if (FileManager.getInstance().getSound()==1)
        playMusic();
    }


    private void setClip () {
         Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
    /*     To find the the mixer
         for (Mixer.Info info :mixInfos)
         {
             System.out.println("---" + info.getName() + "---" + info.getDescription() + "\n");
         }
    */
        mixer = AudioSystem.getMixer(mixInfos[0]);

        try  {clip = (Clip) mixer.getLine(new DataLine.Info(Clip.class,null)); }
        catch (LineUnavailableException lue){ lue.printStackTrace();}

        try {clip.open(FileManager.getInstance().getAudioInputStream());}
        catch (LineUnavailableException lue){lue.printStackTrace();}
        catch(IOException ioe){ioe.printStackTrace();}

        volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        muteControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);

         max = volumeControl.getMaximum();
         min = volumeControl.getMinimum();


    }

    private void playMusic() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    private void stopMusic() {
        clip.stop();
    }

    private void adjustVolume () {
        System.out.println("max: " + max + " min: " + min);
        float range = max-(min/2f);
        float sliderValue = (float)volumeBar.getValue();
        float sliderRange =  (float)(volumeBar.getMaximum() - volumeBar.getMinimum());
        float gainValue = ((sliderValue/sliderRange)*range)-40f;
        System.out.println("range: " + range);
        System.out.println("sliderValue: " + sliderValue);
        System.out.println("sliderRange: "+ sliderRange);
        System.out.println("gainValue: " + gainValue);
        if(!((int)sliderValue< 5))
            volumeControl.setValue(gainValue);
        else
            volumeControl.setValue(-80f);

    }

    private void createUIComponents() {
        customizationPanel = new CustomizationPanel();
        customPanel = customizationPanel.getCustomizationPanel();
    }
}
