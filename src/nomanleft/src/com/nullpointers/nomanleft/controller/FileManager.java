package com.nullpointers.nomanleft.controller;

import java.io.*;

public class FileManager {

    private final static FileManager instance = new FileManager();
    private final static String USER_INFORMATION = "userinformation";
    private int customization;
    private int gold;
    private int sound;

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
}
