package com.nullpointers.nomanleft.controller;

import com.nullpointers.nomanleft.model.Wall;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FileManager {

    private final static FileManager instance = new FileManager();
    private final static String USER_INFORMATION = "./resources/userinformation";
    private int customization = 1;
    private int gold = 0;
    private int highScore;
    private int sound = 1;
    private int soundLevel = 50;
    private Image bush;
    private Image wallTile;
    private Image ground;
    private Image lava;
    private Image mountain;
    private Image tower;
    private Image friendSoldier;
    private Image enemySoldier;
    private Image pickaxe;
    private Image fill;
    private Image move;
    private final static int WIDTH = 100;
    private final static int HEIGHT = 100;
    private final int MAP_SIZE = 13;
    private ArrayList<Wall> walls = new ArrayList<>();
    private File userFile;

    private FileManager(){
        userFile = new File(USER_INFORMATION);
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
            st = br.readLine();
            soundLevel = Integer.parseInt(st.split(":")[1]);
            st = br.readLine();
            highScore = Integer.parseInt(st.split(":")[1]);

            //Getting Game Images
            bush = ImageIO.read(new File("./resources/img/bush" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            wallTile = ImageIO.read(new File("./resources/img/walltile" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            ground = ImageIO.read(new File("./resources/img/ground" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            lava = ImageIO.read(new File("./resources/img/lava" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            mountain = ImageIO.read(new File("./resources/img/mountain" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            tower = ImageIO.read(new File("./resources/img/tower" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            friendSoldier = ImageIO.read(new File("./resources/img/friendsoldier" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            enemySoldier = ImageIO.read(new File("./resources/img/enemysoldier" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            pickaxe = ImageIO.read(new File("./resources/img/pickaxe" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            fill = ImageIO.read(new File("./resources/img/fill" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            move = ImageIO.read(new File("./resources/img/move" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if ( br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        File wallFiles = new File("./resources/walls");
        int id = 1;
        for (File wallFile: Objects.requireNonNull(wallFiles.listFiles())){
            try {
                br = new BufferedReader(new FileReader(wallFile));
                int[][] wallShape = new int[MAP_SIZE][MAP_SIZE];
                for (int i = 0; i < MAP_SIZE; i++) {
                    String currentLine = br.readLine();
                    for (int j = 0; j < MAP_SIZE; j++) {
                        wallShape[i][j] = currentLine.charAt(j) - '0';
                    }
                }
                walls.add(new Wall(wallShape, id));
            } catch (IOException e) {
                e.printStackTrace();
            }
            id++;
        }

        setGold(10);

    }

    public static FileManager getInstance(){
        return instance;
    }

    public int getCustomization() {
        return customization;
    }

    public void setCustomization(int customization) {
        this.customization = customization;
        //Getting Game Images
        try {
            bush = ImageIO.read(new File("./resources/img/bush" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            wallTile = ImageIO.read(new File("./resources/img/walltile" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            ground = ImageIO.read(new File("./resources/img/ground" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            lava = ImageIO.read(new File("./resources/img/lava" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            mountain = ImageIO.read(new File("./resources/img/mountain" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            tower = ImageIO.read(new File("./resources/img/tower" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            friendSoldier = ImageIO.read(new File("./resources/img/friendsoldier" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            enemySoldier = ImageIO.read(new File("./resources/img/enemysoldier" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            pickaxe = ImageIO.read(new File("./resources/img/pickaxe" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            fill = ImageIO.read(new File("./resources/img/fill" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            move = ImageIO.read(new File("./resources/img/move" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToUserFile();
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
        writeToUserFile();
    }

    public int getSound() {
        return sound;
    }

    public void changeSound() {
        this.sound = sound == 0 ? 1:0;
        writeToUserFile();
    }

    private void writeToUserFile() {
        BufferedWriter br = null;
        try {
            br = new BufferedWriter(new FileWriter(userFile));
            br.write("customization:" + customization +"\n" +
                    "gold:" + gold + "\n" +
                    "sound:" + sound + "\n" +
                    "soundlevel:" + soundLevel + "\n" +
                    "highScore:" + highScore);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if ( br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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

    public Image getDigImage(){ return pickaxe; }

    public Image getMoveImage(){ return move; }

    public Image getFillImage(){ return fill; }

    public BufferedReader getLevel(int level){
        File levelFile = new File("./resources/normallevels/level" + level + ".txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(levelFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public Image getFriendSoldier() {
        return friendSoldier;
    }

    public void setFriendSoldier(Image friendSoldier) {
        this.friendSoldier = friendSoldier;
    }

    public Image getEnemySoldier() {
        return enemySoldier;
    }

    public void setEnemySoldier(Image enemySoldier) {
        this.enemySoldier = enemySoldier;
    }

    public int getHighScore () {
       return highScore;
    }

    public void setHighScore (int highScore) {
        this.highScore = highScore;
        writeToUserFile();
    }

    public int getSoundLevel() {
        return soundLevel;
    }

    public void setSoundLevel(int soundLevel) {
        this.soundLevel = soundLevel;
        writeToUserFile();
    }
}
