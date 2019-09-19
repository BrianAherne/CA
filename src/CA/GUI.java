package CA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


 //Created by t00160248 on 29/11/2017.

public class GUI extends JFrame implements ActionListener { //adding menu, menu bar, menu options and labels to be used in the GUI
    private JMenu mainMenu, Save;
    private JMenuBar Menu;
    private JMenuItem save, load, exit, start;
    private ImageIcon userImg, enemyImg;
    private JLabel userL, enemyL;
    //private JButton attButton, defButton;
    private JPanel GUIuser, GUIenemy, button; //adding the panels and initializing the JFrame
    private JFrame frame = new JFrame("RPG");

    static int characterCount;
    static ArrayList<User> users; //setting up an arrayList of User objects for saving
/**
 * Creates the GUI
  **/
    public GUI(){
//Setting the size, location close operation and layout of the GUI
        frame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);//code taken from StackOverflow https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));
//initialising the menu items
        save = new JMenuItem();
        load = new JMenuItem();
        exit = new JMenuItem();
        start = new JMenuItem();
        //newCharacter = new JMenuItem();
//Adding Action Listeners to menu items
        save.addActionListener(this);
        load.addActionListener(this);
        exit.addActionListener(this);
        start.addActionListener(this);
        //newCharacter.addActionListener(this);
//initializing the JMenus
        mainMenu = new JMenu();
        Save = new JMenu();
        Menu = new JMenuBar();
//Setting the text to appear for each of the menu components
        mainMenu.setText("Options");
        Save.setText("Save/Load");
        save.setText("Save");
        load.setText("Load");
        exit.setText("Exit");
        start.setText("Start");
        //newCharacter.setText("New Character");
//Adding the menus to the menu bar
        Menu.add(mainMenu);
        Menu.add(Save);
//Adding the menu options to the menus
        mainMenu.add(start);
        //mainMenu.add(newCharacter);
        mainMenu.add(exit);
        Save.add(save);
        Save.add(load);
//Setting the layout of the meny to a flowlayout and setting the menu bar
        Menu.setLayout(new FlowLayout());
        frame.setJMenuBar(Menu);
//initializing the panels
        GUIuser = new JPanel(new FlowLayout());
        GUIenemy = new JPanel(new FlowLayout());
        //button = new JPanel (new FlowLayout());

//initializing the labels
        userL = new JLabel();
        enemyL = new JLabel();
//setting default enemy image to be displayed. Coded with the help of Mark O'Donoghue
        enemyImg = new ImageIcon("Images//orc.jpg");
        enemyL.setIcon(enemyImg);
        GUIenemy.add(enemyL);
        frame.add(GUIenemy);
//setting the default user image to be displayed
        userImg = new ImageIcon("Images//human.png");
        userL.setIcon(userImg);
        GUIuser.add(userL);
        frame.add(GUIuser);

        //attButton = new JButton("Attack");
        //defButton = new JButton("Defend");
        //attButton.setSize(80,80);
        //button.add(attButton);
        //button.add(defButton);
        //button.setVisible(false);

        //frame.add(GUIuser);
        //frame.add(GUIenemy);

        //button.add(attButton);
        //button.add(defButton);

        //frame.add(button);
        //attButton.addActionListener(this);
        //defButton.addActionListener(this);
//making the JFrame visible
        frame.setVisible(true);




    }
/**
 * controlling what happens when GUI options are selected
  **/
    public void actionPerformed(ActionEvent e) {
//exiting the system
        if (e.getSource() == exit) {
            System.exit(0);
        }

        //if(e.getSource() == newCharacter){
        //User user = Character.createUser();
        //}

        if (e.getSource() == save) {
//saving
            try {
                SaveAndLoad.objectOutputStream();
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null,"Could not save the file!");
            }
        }

        if (e.getSource() == load) {
//loading
            try {
                SaveAndLoad.objectInputStream();
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, "Could not load the file");
            }
        }

        if (e.getSource() == start) {
            //if(!users.isEmpty()) {
                //User user = users.get(characterCount);
            //}
//Starting the game by creating a user and enemy
            User user = createUser();
            Enemy enemy = createEnemy();
//running the main battle method
            battle(user,enemy);
//once the battle is finished, asks if you wish to continue or quit
            int decision = Integer.parseInt(JOptionPane.showInputDialog("Continue or give up? (1,2)"));
            while (decision != 2 && decision != 1) {
                decision = Integer.parseInt(JOptionPane.showInputDialog("Invalid choice! Continue or give up? 1,2"));
            }

                if (decision == 1) {
                    Enemy newEnemy = createEnemy();
                    battle(user, newEnemy);

                }
                else
                    return;
            }

        /*if(e.getSource() == attButton){
            userAttack();

        }

        if(e.getSource() == defButton){
            userDefend();
        }*/

        }
/**
 * main battle method
 * **/
    public void battle(User user, Enemy enemy) {

        double originalDef = user.getDef();
        double originalHp = user.getHp();
//getting the user type and setting the appropriate image
        String type = user.getType();
        if (type.equals("h")){
            GUIuser.remove(userL);
            userImg = new ImageIcon("Images//human.png");
            userL.setIcon(userImg);
            GUIuser.setBackground(Color.blue);
            GUIuser.add(userL);
            GUIuser.revalidate();
            GUIuser.repaint();
        }
        else if (type.equals("e")){
            GUIuser.remove(userL);
            userImg = new ImageIcon("Images//elf.jpg");
            userL.setIcon(userImg);
            GUIuser.setBackground(Color.MAGENTA);
            GUIuser.add(userL);
            GUIuser.revalidate();
            GUIuser.repaint();
        }
        else if(type.equals("d")){
            GUIuser.remove(userL);
            userImg = new ImageIcon("Images//dwarf.png");
            userL.setIcon(userImg);
            GUIuser.setBackground(Color.RED);
            GUIuser.add(userL);
            GUIuser.revalidate();
            GUIuser.repaint();
        }
        else {
            GUIuser.remove(userL);
            userImg = new ImageIcon("Images//orc.jpg");
            userL.setIcon(userImg);
            GUIuser.setBackground(Color.GREEN);
            GUIuser.add(userL);
            GUIuser.revalidate();
            GUIuser.repaint();
        }
//initiation to see if the user or enemy has the first turn
        int userInitiation = 0;

        if (user.getAtt() > enemy.getAtt()) {
            userInitiation = 0;
        } else {
            userInitiation = 1;
        }
//setting the appropriate enemy image
        String enemyType = enemy.getType();
        if(enemyType == "h") {
            enemyType = "Human";
            GUIenemy.remove(enemyL);
            enemyImg = new ImageIcon("Images//human.png");
            enemyL.setIcon(enemyImg);
            GUIenemy.setBackground(Color.blue);
            GUIenemy.add(enemyL);
            GUIenemy.revalidate();
            GUIenemy.repaint();
        }
        else if(enemyType =="e") {
            enemyType = "Elf";
            GUIenemy.remove(enemyL);
            enemyImg = new ImageIcon("Images//elf.jpg");
            enemyL.setIcon(enemyImg);
            GUIenemy.setBackground(Color.MAGENTA);
            GUIenemy.add(enemyL);
            GUIenemy.revalidate();
            GUIenemy.repaint();
        }
        else if (enemyType =="d") {
            enemyType = "Dwarf";
            GUIenemy.remove(enemyL);
            enemyImg = new ImageIcon("Images//dwarf.png");
            enemyL.setIcon(enemyImg);
            GUIenemy.setBackground(Color.RED);
            GUIenemy.add(enemyL);
            GUIenemy.revalidate();
            GUIenemy.repaint();
        }
        else {
            enemyType = "Orc";
            GUIenemy.remove(enemyL);
            enemyImg = new ImageIcon("Images//orc.jpg");
            enemyL.setIcon(enemyImg);
            GUIenemy.setBackground(Color.GREEN);
            GUIenemy.add(enemyL);
            GUIenemy.revalidate();
            GUIenemy.repaint();
        }
        JOptionPane.showMessageDialog(null,"You are fighting a " + enemyType);
//setting the turn order while the user or the enemy have Hit Points remaining
        if (userInitiation == 0){
            while(user.getHp()>0 && enemy.getHp()>0){
                UserTurn(user, enemy);
                EnemyTurn(user,enemy);
            }
        }
        else{
            while(enemy.getHp()>0 && user.getHp()>0){
                EnemyTurn(user,enemy);
                UserTurn(user,enemy);
            }
        }
//win condition of enemy reaching 0Hp
        if(enemy.getHp()<=0){
            JOptionPane.showMessageDialog(null,"You win");
            user.setExp(user.getExp() + 50);
        }
//lose condition of user reaching 0Hp
        else
            JOptionPane.showMessageDialog(null,"You lose");
//displaying the end of the battle
        JOptionPane.showMessageDialog(null,"The battle is over");
//returning the user's defense and hitpoints to the values they were before the battle began
        user.setDef(originalDef);
        user.setHp(originalHp);
//displaying the users stats and experience
        JOptionPane.showMessageDialog(null, "Your stats are: \nAttack: " +user.getAtt() +
                "\nDefense: " + user.getDef() + "\nHit Points: " + user.getHp() + "\nExperience Points: " + user.getExp());
//checking the user's experience points to see if they leveled up
        checkExp(user);
    }
/**
 * determining the action the user wishes to take on their turn
  **/
    public void UserTurn(User user, Enemy enemy){
        String nextMove = JOptionPane.showInputDialog("USER 1 att, 2 def\n Your stats are: \nAttack: "+ user.getAtt() + "\nDefense: " + user.getDef() + "\nHp" + user.getHp());
        while(!nextMove.equals("1") && !nextMove.equals("2"))
        {
            nextMove = JOptionPane.showInputDialog("Invalid choice. Select again (1 attack, 2 defend");
        }
        int nMove = Integer.parseInt(nextMove);
        if (nMove == 1){
            userAttack(user,enemy);
        }
        if(nMove==2){
            userDefend(user);
        }


    }
/**
 * determining the action the enemy takes on their turn
  **/
    public void EnemyTurn(User user, Enemy enemy){
        JOptionPane.showMessageDialog(null,"Enemy's turn\nEnemy's Stats: " +
                "\nAttack: " +enemy.getAtt() + "\nDefense: " + enemy.getDef() + "\nHit Points: " + enemy.getHp());
//making the enemy action random
        double enemyMove = Math.random();
        if (enemyMove <0.5){
            enemyAttack(enemy, user);
        }
        if (enemyMove>0.5){
            enemyDefend(enemy);
            JOptionPane.showMessageDialog(null,"The enemy defends");
        }
        else
            return;
    }
/**
 * if the user decides to attack
  **/
    public void userAttack (User user, Enemy enemy) {
        if (user.getAtt() > enemy.getDef()) {
            enemy.setHp(enemy.getHp()-user.getAtt());
            JOptionPane.showMessageDialog(null,"You Attack for " + user.getAtt() + " points of damage");

        }
        else {
            enemy.setHp(enemy.getHp() - user.getAtt()/2);
            JOptionPane.showMessageDialog(null,"You Attack for " + user.getAtt()/2 + " points of damage");
        }
        return;

    }
/**
 * if the enemy decides to attack
  **/
    public void enemyAttack (Enemy enemy, User user) {
        if(enemy.getAtt() > user.getDef()){
            user.setHp((user.getHp() -enemy.getAtt()));
            JOptionPane.showMessageDialog(null,"The enemy attacks for " + enemy.getAtt() + " points of damage");
        }
        else {
            user.setHp(user.getHp()-enemy.getAtt()/2);
            JOptionPane.showMessageDialog(null,"The enemy attacks for " + enemy.getAtt()/2 + " points of damage");
        }
    }
/**
 * if the user decides to defend
  **/
    public void userDefend(User user){
        double originalDef = user.getDef();
        user.setDef(user.getDef()+10);
        JOptionPane.showMessageDialog(null,"Your def is now " + user.getDef());
    }
/**
 * if the enemy decides to defend
  **/
    public void enemyDefend(Enemy enemy){enemy.setDef(enemy.getDef()+10);}
/**
 * checking the users exp points. If exp is high enough the user can choose a stat to increase
  **/
    public void checkExp(User user){
        if (user.getExp() == 100){
            int choice = Integer.parseInt(JOptionPane.showInputDialog("You've leveled up. Select a stat to increase (1 att, 2 def, 3 hp)"));

            while(choice!=1&&choice!=2&&choice!=3){
                choice = Integer.parseInt(JOptionPane.showInputDialog("Invalid choice! Select again! 1 att, 2 def, 3 hp"));
            }
            if (choice == 1){
                user.setAtt(user.getAtt() + 10);
            }
            else if (choice == 2){
                user.setDef(user.getDef() +10);
            }
            else
                user.setHp(user.getHp() + 10);
//setting the exp back to 0
            user.setExp(0);
        }
    }
/**
 * creating a User object and adding the object to an array list
  **/
    public static User createUser() {
        users = new ArrayList<>();
        String type = JOptionPane.showInputDialog("Please enter your character's race: (h:human, e:elf, d:dwarf, o:orc)");
        while (!type.equals("h") && !type.equals("e") && !type.equals("d") && !type.equals("o")) {
            type = JOptionPane.showInputDialog("Invalid choice, please pick again: (h:human, e:elf, d:dwarf, o:orc)");
        }

        User user = new User(type);
        users.add(user);
        characterCount++;

        return user;
    }
/**
 * creating an Enemy object and making it Type random so you don't fight the same enemy everytime
  **/
    public static Enemy createEnemy(){
        String enemyType = "";
        double eType = Math.random();
        if (eType < 0.25)
            enemyType = "h";
        else if (eType > 0.25 && eType < 0.5)
            enemyType = "e";
        else if (eType > 0.5 && eType < 0.75)
            enemyType = "d";
        else
            enemyType = "o";
        Enemy enemy = new Enemy(enemyType);
        return enemy;

    }

}
