package com.nullpointers.nomanleft.controller;

import com.nullpointers.nomanleft.model.MapObject;
import com.nullpointers.nomanleft.model.Soldier;
import com.nullpointers.nomanleft.model.Wall;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.sound.sampled.*;

public class FileManager {

    private final static FileManager instance = new FileManager();
    private final static String USER_INFORMATION = "./resources/userinformation";
    private int customization = 1;
    private int gold = 0;
    private int highScore;
    private int sound = 1;
    private int soundLevel = 50;
    private int hideBooster = 0, digBooster = 0, fillBooster = 0, moveBooster = 0;
    private Image bush;
    private Image wallTile;
    private Image largeWallTile;
    private Image rotateLargeWallTile;
    private Image ground;
    private Image lava;
    private Image mountain;
    private Image largeMountain;
    private Image tower;
    private Image friendSoldier;
    private Image enemySoldier;
    private Image pickaxe;
    private Image fill;
    private Image move;
    private Image WallPic1;
    private Image WallPic2;
    private Image WallPic3;
    private Image WallPic4;



    private Image backgroundImage1;
    private AudioInputStream aiStream;
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
            st = br.readLine();
            hideBooster = Integer.parseInt(st.split(":")[1]);
            st = br.readLine();
            digBooster = Integer.parseInt(st.split(":")[1]);
            st = br.readLine();
            fillBooster = Integer.parseInt(st.split(":")[1]);
            st = br.readLine();
            moveBooster = Integer.parseInt(st.split(":")[1]);

            //Getting Game Images
            bush = ImageIO.read(new File("./resources/img/bush" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            wallTile = ImageIO.read(new File("./resources/img/walltile" + 1 + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            largeWallTile = ImageIO.read(new File("./resources/img/largeWall" + 1 + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            rotateLargeWallTile = ImageIO.read(new File("./resources/img/rotateLargeWall" + 1 + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            ground = ImageIO.read(new File("./resources/img/ground" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            lava = ImageIO.read(new File("./resources/img/lava" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            mountain = ImageIO.read(new File("./resources/img/mountain" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            largeMountain = ImageIO.read(new File("./resources/img/largemountain" + 1 + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            tower = ImageIO.read(new File("./resources/img/tower" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            friendSoldier = ImageIO.read(new File("./resources/img/friendsoldier" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            enemySoldier = ImageIO.read(new File("./resources/img/enemysoldier" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            pickaxe = ImageIO.read(new File("./resources/img/pickaxe" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            fill = ImageIO.read(new File("./resources/img/fill" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            move = ImageIO.read(new File("./resources/img/move" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            WallPic1 = ImageIO.read(new File("./resources/img/WallResim1.jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            WallPic2 = ImageIO.read(new File("./resources/img/WallResim2.jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            WallPic3 = ImageIO.read(new File("./resources/img/WallResim3.jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            WallPic4 = ImageIO.read(new File("./resources/img/WallResim4.jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            backgroundImage1 = ImageIO.read(new File("./resources/img/backgroundImage1.jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
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

        try {aiStream = AudioSystem.getAudioInputStream(new File("./resources/music/music.wav"));}
        catch(UnsupportedAudioFileException uafe){uafe.printStackTrace();}
        catch(IOException ioe){ioe.printStackTrace();}
    }

    public static FileManager getInstance(){
        return instance;
    }

    public String filename(){
        return "";
    }

    public int getNumberOfNormalLevels(){
        int level = 1;
        File file;
        while(true){
            file = new File("./resources/normallevels/level" + level + ".txt");
            if(file.exists()){
                level++;
                continue;
            }
            else {
                return level - 1;
            }
        }
    }

    public int getNumberOfSandboxLevels(){
        int level = 1;
        File file;
        while(true){
            file = new File("./resources/sandboxlevels/level" + level + ".txt");
            if(file.exists()){
                level++;
                continue;
            }
            else {
                return level - 1;
            }
        }
    }

    private String findNametoFile(){
        int level = 1;
        File file;
        while(true){
            file = new File("./resources/sandboxlevels/level" + level + ".txt");
            if(file.exists()){
                level++;
                continue;
            }
            else {
                break;
            }
        }
        return "./resources/sandboxlevels/level" + level + ".txt";
    }

    public void write (MapObject[][] map, boolean bool1, boolean bool2, boolean bool3, boolean bool4){
        try {

            BufferedWriter outputWriter = null;
            outputWriter = new BufferedWriter(new FileWriter(findNametoFile()));
            for (int i = 0; i < MAP_SIZE; i++) {
                for (int j = 0; j < MAP_SIZE; j++) {
                    if (j < MAP_SIZE - 1)
                        if ( map[i][j] instanceof Soldier) {
                            outputWriter.write(((Soldier)map[i][j]).getName() + ",");
                        }
                        else{
                            outputWriter.write(map[i][j].getClass().getSimpleName() + ",");
                        }
                    else
                        outputWriter.write(map[i][j].getClass().getSimpleName());
                }
                outputWriter.newLine();
            }
            if (bool1)
                outputWriter.write("1,");
            if (bool2)
                outputWriter.write("3,");
            if (bool3)
                outputWriter.write("4,");
            if (bool4)
                outputWriter.write("5,");
            outputWriter.write("2");
            outputWriter.flush();
            outputWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public int getCustomization() {
        return customization;
    }

    public void setCustomization(int customization) {
        this.customization = customization;
        //Getting Game Images
        try {
            bush = ImageIO.read(new File("./resources/img/bush" + customization + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            wallTile = ImageIO.read(new File("./resources/img/walltile" + 1 + ".jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
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
        System.out.println("Set Gold");
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
                    "highScore:" + highScore +"\n" +
                    "hide:" + hideBooster + "\n" +
                    "dig:" + digBooster + "\n" +
                    "fill:" + fillBooster + "\n" +
                    "move:" + moveBooster + "\n" );
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
    public Image getLargeWallTile() {
        return largeWallTile;
    }
    public Image getRotateLargeWallTile() {
        return rotateLargeWallTile;
    }
    public Image getGround() {
        return ground;
    }

    public Image getLava() {
        return lava;
    }

    public Image getMountain() { return mountain; }

    public Image getLargeMountain() {
        return largeMountain;
    }

    public Image getTower() {
        return tower;
    }

    public Image getDigImage(){
        return pickaxe;
    }

    public Image getMoveImage(){ return move; }

    public Image getFillImage(){ return fill; }
    public Image getBackgroundImage1() {
        return backgroundImage1;
    }
    public Image getWallPic1(){return WallPic1;}
    public Image getWallPic2(){return WallPic2;}
    public Image getWallPic3(){return WallPic3;}
    public Image getWallPic4(){return WallPic4;}

    public BufferedReader getNormalLevel(int level){
        File levelFile = new File("./resources/normallevels/level" + level + ".txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(levelFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
    }

    public BufferedReader getSandboxLevel(int level){
        File levelFile = new File("./resources/sandboxlevels/level" + level + ".txt");
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

    public int getHideBooster() {
        return hideBooster;
    }

    public void setHideBooster(int boosterCount) {

        hideBooster = boosterCount;
        writeToUserFile();

    }

    public int getDigBooster() {
        return digBooster;
    }

    public void setDigBooster(int boosterCount) {

        digBooster = boosterCount;
        writeToUserFile();

    }

    public int getFillBooster() {
        return fillBooster;
    }

    public void setFillBooster(int boosterCount) {
        fillBooster = boosterCount;
        writeToUserFile();


    }

    public int getMoveBooster() {
        return moveBooster;
    }

    public void setMoveBooster(int boosterCount) {
        moveBooster = boosterCount;
        writeToUserFile();

    }

    public AudioInputStream getAudioInputStream () {
        return aiStream;
    }

}
