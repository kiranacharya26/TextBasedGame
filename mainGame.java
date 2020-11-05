package com.game.myFirstGame;

import sun.font.FontFamily;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainGame {
    JFrame window;
    Container con;
    JPanel titleNamePanel,setStartButtonPanel,mainTextPanel,choiceButtonPannel,playerPannel;
    JLabel titleTextLabel,chakraNumber,chakraLabelNumber,jutsuNumber,jutsuLabelName;
    Font titleFont = new Font("fantasy",Font.PLAIN, 50);
    Font normalFont = new Font("Times New Roman",Font.PLAIN, 30);
    Font textAreaFont = new Font("Comic Sans",Font.PLAIN, 28);
    JButton startButton,ch1,ch2,ch3,ch4;
    int playerChakra,enemyChakra;
    String playerJutsu, posistion;


    JTextArea mainTextArea;

    TitleScreenHandler tHandler = new TitleScreenHandler();
    choiceHandler cHandler = new choiceHandler();

    public static void main(String[] args){
        new mainGame();

    }
    public mainGame(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        con = window.getContentPane();
        //Title of the Game name
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,50,600,130);
        titleNamePanel.setBackground(Color.BLACK);
        titleTextLabel = new JLabel("Are you a SHINOBI?");
        titleTextLabel.setForeground(Color.ORANGE);
        titleTextLabel.setFont(titleFont);

        setStartButtonPanel = new JPanel();
        setStartButtonPanel.setBounds(300,400,200,100);
        setStartButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        //Button border color
        startButton.setFocusPainted(false);
        startButton.addActionListener(tHandler);

        titleNamePanel.add(titleTextLabel);
        setStartButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(setStartButtonPanel);

        window.setVisible(true);

    }

    public  void createGameScreen(){
        titleNamePanel.setVisible(false);
        setStartButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(textAreaFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPannel  = new JPanel();
        choiceButtonPannel.setBounds(110,350,550,200);
        choiceButtonPannel.setBackground(Color.black);
        choiceButtonPannel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPannel);

        ch1 = new JButton();
        ch1.setBackground(Color.BLACK);
        ch1.setForeground(Color.ORANGE);
        ch1.setFont(textAreaFont);
        ch1.addActionListener(cHandler);
        ch1.setActionCommand("c1");
        ch1.setFocusPainted(false);
        choiceButtonPannel.add(ch1);
        ch2 = new JButton();
        ch2.setBackground(Color.BLACK);
        ch2.setForeground(Color.ORANGE);
        ch2.setFont(textAreaFont);
        ch2.addActionListener(cHandler);
        ch2.setActionCommand("c2");
        ch2.setFocusPainted(false);
        choiceButtonPannel.add(ch2);
        ch3 = new JButton();
        ch3.setBackground(Color.BLACK);
        ch3.setForeground(Color.ORANGE);
        ch3.setFont(textAreaFont);
        ch3.addActionListener(cHandler);
        ch3.setFocusPainted(false);
        ch3.setActionCommand("c3");
        choiceButtonPannel.add(ch3);
        ch4 = new JButton();
        ch4.setBackground(Color.BLACK);
        ch4.setForeground(Color.ORANGE);
        ch4.setFont(textAreaFont);
        ch4.addActionListener(cHandler);
        ch4.setFocusPainted(false);
        ch4.setActionCommand("c4");
        choiceButtonPannel.add(ch4);

        playerPannel = new JPanel();
        playerPannel.setBounds(100,15,600,80);
        playerPannel.setBackground(Color.BLACK);
        playerPannel.setLayout(new GridLayout(1,4));
        con.add(playerPannel);
        //For Chakra mod
        chakraNumber = new JLabel("Chakra:");
        chakraNumber.setFont(textAreaFont);
        chakraNumber.setForeground(Color.white);
        playerPannel.add(chakraNumber);

        chakraLabelNumber = new JLabel();
        chakraLabelNumber.setFont(textAreaFont);
        chakraLabelNumber.setForeground(Color.white);
        playerPannel.add(chakraLabelNumber);
        //for Jutsu Mod
        jutsuNumber = new JLabel("Jutsu:");
        jutsuNumber.setFont(textAreaFont);
        jutsuNumber.setForeground(Color.white);
        playerPannel.add(jutsuNumber);

        jutsuLabelName = new JLabel();
        jutsuLabelName.setFont(textAreaFont);
        jutsuLabelName.setForeground(Color.white);
        playerPannel.add(jutsuLabelName);

        playerSetup();

    }

    public void playerSetup(){
        playerChakra = 100;
        enemyChakra = 100;
        playerJutsu = "Tai Jutsu";
        jutsuLabelName.setText(playerJutsu);
        chakraLabelNumber.setText(String.valueOf(playerChakra));
        konohaVillage();

    }
    public void konohaVillage(){
        posistion = "Konoha Village";
        mainTextArea.setText("You are in konoha-The Leaf Village. \n Please select a choice to proceed.");

        ch1.setText("Shinobi War 3");
        ch2.setText("Akatsuki");
        ch3.setText("Training");
        ch4.setText("Wander");
    }
    public void enterWar (){
        posistion = "Battle Field";
        mainTextArea.setText("Your now in the middle of the war! what you want to do? \nLook at your chakra level before attacking");
        ch1.setText("Attack the weak opponents");
        ch2.setText("Attack the stronger opponents");
        ch3.setText("Ask for help");
        ch4.setText("Run away!");

    }
    public void weakOpponents(){
        posistion = "Weak Opppo";
        mainTextArea.setText("Your fighting with clone bodies, Congratulations- You Win!");
        ch1.setText("Go back to fight stronger enemies");
        ch2.setText("");
        ch3.setText("");
        ch4.setText("");
    }
    public void joinAkatsuki (){
        posistion = "Join Akatsuki";
        mainTextArea.setText("Now you have joined the dark side, \n which Tail beast do you want to capture?");
        playerChakra = playerChakra -3;
        chakraLabelNumber.setText(String.valueOf(playerChakra));
        ch1.setText("One Tail Beast(Gaara)");
        ch2.setText("Four Tails Beast(Rōshi)");
        ch3.setText("Eight Tails Beast(Bee)");
        ch4.setText("Nine Tails Beast(Naruto)");

    }
    public void trainWithMasters (){
        posistion = "Training area";
        mainTextArea.setText("This is the trainig area, \nHere you can learn all kinds of justsu's \n and increase your chakra level. \n You can only learn one jutsu");
        ch1.setText("I can fight only with Taijustsu");
        ch2.setText("Learn Ninjutsu");
        ch3.setText("Learn Genjustsu");
        ch4.setText("Learn Dojutsu");

    }
    public void freeWalk (){
        posistion = "Wander";
        mainTextArea.setText("Your in a dense forest, select a direction!");
        ch1.setText("Go near the river");
        ch2.setText("Climb the mountain");
        ch3.setText("Talk to strangers");
        ch4.setText("Leave the forest");

    }
  public class TitleScreenHandler implements ActionListener{


      public void actionPerformed(ActionEvent actionEvent) {
          createGameScreen();

      }
  }
  public class choiceHandler implements ActionListener{


      public void actionPerformed(ActionEvent actionEvent) {
          String yourChoice = actionEvent.getActionCommand();

          switch (posistion){
              case "Konoha Village":
              switch (yourChoice) {
                  case "c1": enterWar();break;
                  case "c2": joinAkatsuki();break;
                  case "c3": trainWithMasters(); break;
                  case "c4": freeWalk(); break;
              }
              break;
              case "Battle Field":
                  switch (yourChoice){
                      case "c1":weakOpponents();break;
                  }
                  break;
              case "Weak Opppo":
                  switch (yourChoice){
                      case "c1":enterWar();break;
                      case "c2":break;
                      case "c3":break;
                      case "c4":break;


                  }
                  break;
          }
      }
  }
}
