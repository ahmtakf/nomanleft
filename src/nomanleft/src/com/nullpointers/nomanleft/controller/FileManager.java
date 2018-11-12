package com.nullpointers.nomanleft.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private final static FileManager instance = new FileManager();
    private final static String USER_INFORMATION = "./resources/userinformation";
    private int customization = 1;
    private int gold = 0;
    private int sound = 1;
    private Image bush;
    private Image wallTile;
    private Image ground;
    private Image lava;
    private Image mountain;
    private Image tower;
    private final int WIDTH = 100;
    private final int HEIGHT = 100;

    private FileManager(){
        File userFile = new File(USER_INFORMATION);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(userFile));
            //Getting user choices
            String st = br.readLine();
            customization = Integer.parseInt(st.split(":")[1]);
            st = br.readLine();
            gold = Integer.parseInt(st.split(":")[1]);
            st = br.readLine();
            sound = Integer.parseInt(st.split(":")[1]);

            //Getting Tile Images
            bush = ImageIO.read(new File("./resources/img/bush" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            wallTile = ImageIO.read(new File("./resources/img/walltile" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            ground = ImageIO.read(new File("./resources/img/ground" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            lava = ImageIO.read(new File("./resources/img/lava" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            mountain = ImageIO.read(new File("./resources/img/mountain" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            tower = ImageIO.read(new File("./resources/img/tower" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static FileManager getInstance(){
        return instance;
    }

    public int getCustomization() {
        return customization;
    }

    public void setCustomization(int customization) {
        this.customization = customization;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public Image getBush() {
        return bush;
    }

    public Image getWallTile() {
        return wallTile;
    }

    public Image getGround() {
        return ground;
    }

    public Image getLava() {
        return lava;
    }

    public Image getMountain() {
        return mountain;
    }

    public Image getTower() {
        return tower;
    }
}
