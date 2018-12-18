package com.nullpointers.nomanleft.view;

import com.nullpointers.nomanleft.controller.FileManager;
import com.nullpointers.nomanleft.controller.GameManager;

import javax.swing.*;
import javax.swing.Timer;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.*;
import java.time.Instant;
import java.time.Duration;
import java.util.Random;

public class TimeTrial {

    private static final int MAX_TIME = 50 ;
    private static final int MAX_LEVEL_NO = 3;
    private int[] levelNumbers = new int[MAX_LEVEL_NO];
    private int highScore = 0 ;
    private int levelCount = -1;
    private Timer timer1, timer2;
    private Instant startTime;
    private LevelPanel currentLevel;

    public TimeTrial () {
        //get high score
        highScore = FileManager.getInstance().getHighScore();


        //set timer1
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                finished();
            }
        };
        timer1 = new Timer(MAX_TIME * 1000, taskPerformer);

        //set timer2 for guı update
         startTime = Instant.now();
        ActionListener taskPerformer2 = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updatePassedTime();
            }
        };
        timer2 = new Timer(1000, taskPerformer2);
    }

    public LevelPanel changeLevel () {
        levelCount++;

        if (levelCount >= MAX_LEVEL_NO) {
            System.out.println("all levels are done ");
            timer1.stop();
            timer2.stop();
            return null;
        }

        int i = 0;
        Random rand = new Random();
        int random = rand.nextInt(MAX_LEVEL_NO) + 1;

        while (i != levelCount) {
        random = rand.nextInt(MAX_LEVEL_NO) + 1;
        System.out.println("level count: " + levelCount);
        i = 0;
            System.out.println("inside the loop");
            for (; i < levelCount; i++) {
                if (levelNumbers[i] == random)
                    break;
            }
        }

        levelNumbers[levelCount] = random;
        GameManager.getInstance().changeCurrentLevel(random);
        currentLevel = new LevelPanel(true, highScore, levelCount);
        System.out.println("returned new levelPanel at changeLevel");
        return currentLevel;
    }

    public void startTimeTrial () {
        //start timeTrial
        GameManager.getInstance().loadNextLevel();
        timer1.start();
        timer2.start();
        System.out.println("Time Trial Starts");
    }

    public void finished () {
        timer1.stop();
        timer2.stop();
        System.out.println("Time Trial Finished");
        if (levelCount > highScore) {
            highScore = levelCount;
            FileManager.getInstance().setHighScore(highScore);
        }
        JOptionPane.showMessageDialog(currentLevel.getLevelPanel(), "Time is over.");
        GameManager.getInstance().openMainMenu();
    }

    public void updatePassedTime(){
        Instant currentTime = Instant.now();
        long timeElapsed = Duration.between(startTime, currentTime).toMillis();
        int remainingTime = MAX_TIME - (int)(timeElapsed/1000);
        currentLevel.updateTimeLabel("Remaining Time: " + remainingTime);
    }
}
