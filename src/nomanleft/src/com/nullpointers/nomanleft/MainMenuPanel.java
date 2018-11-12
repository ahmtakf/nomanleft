package nomanleft.src.com.nullpointers.nomanleft;

import java.awt.*;
import javax.swing.* ;
import javax.swing.border.EmptyBorder;

public class MainMenuPanel extends JPanel{

    private Dimension buttonSpace = new Dimension(1,50);
    private JPanel  buttonContainer;
    private JButton playGame;
    private JButton timeTrial;
    private JButton sandbox;
    private JButton shop;
    private JButton howToPlay;
    private JButton options;
    private JButton credits;
    private JButton exit;
    private JLabel gameName;

    //Constructor
    public MainMenuPanel(){
        super();
        setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setPreferredSize(new Dimension(500,500));

    //initialize buttons

        EmptyBorder buttonBorder =  new EmptyBorder(10, 20, 10, 20);
        playGame = new JButton("PlayGame");
        playGame.setBorder(buttonBorder);
        timeTrial = new JButton("TimeTrial");
        timeTrial.setBorder(buttonBorder);
        sandbox = new JButton("Sandbox");
        sandbox.setBorder(buttonBorder);
        shop = new JButton("Shop");
        shop.setBorder(buttonBorder);
        howToPlay = new JButton("HowToPlay");
        howToPlay.setBorder(buttonBorder);
        options = new JButton ("Options");
        options.setBorder(buttonBorder);
        credits = new JButton ("Credits");
        credits.setBorder(buttonBorder);
        exit = new JButton("Exit");
        exit.setBorder(buttonBorder);


    //initialize Label
        gameName = new JLabel ("<html><h1><strong><i>NoManLeft</i></strong></h1><hr></html>");

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        add(gameName, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

    //add components to a panel
        buttonContainer = new JPanel(new GridBagLayout());

        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(playGame,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(timeTrial,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(sandbox,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(shop,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(howToPlay,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(options,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(credits,gbc);
        buttonContainer.add(Box.createRigidArea(buttonSpace));
        buttonContainer.add(exit,gbc);

        gbc.weighty = 1;
        add(buttonContainer, gbc);



    }

    public void playGame() {

    }

    public void openTimeTrial() {

    }

    public void openSandBox() {

    }

    public void openShop() {

    }

    public void openHowToPlay(){

    }

    public void openCredits(){

    }

    public void openOptions(){

    }

    public void quitGame(){

    }


}
