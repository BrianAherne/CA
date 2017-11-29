package CA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by t00160248 on 29/11/2017.
 */
public class GUI extends JFrame implements ActionListener {
    private JMenu mainMenu, Save;
    private JMenuBar Menu;
    private JMenuItem save, load, exit, start;
    private ImageIcon userImg, enemyImg;
    private JLabel userL, enemyL;
    //private JButton attButton, defButton;
    private JPanel GUIuser, GUIenemy, button;
    private JFrame frame = new JFrame("RPG");

    static int characterCount;
    static ArrayList<User> users;

    public GUI(){

        frame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);//code taken from StackOverflow https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,2));
        save = new JMenuItem();
        load = new JMenuItem();
        exit = new JMenuItem();
        start = new JMenuItem();
        //newCharacter = new JMenuItem();
        save.addActionListener(this);
        load.addActionListener(this);
        exit.addActionListener(this);
        start.addActionListener(this);
        //newCharacter.addActionListener(this);
        mainMenu = new JMenu();
        Save = new JMenu();
        Menu = new JMenuBar();
        mainMenu.setText("Options");
        Save.setText("Save/Load");
        save.setText("Save");
        load.setText("Load");
        exit.setText("Exit");
        start.setText("Start");
        //newCharacter.setText("New Character");
        Menu.add(mainMenu);
        Menu.add(Save);
        mainMenu.add(start);
        //mainMenu.add(newCharacter);
        mainMenu.add(exit);
        Save.add(save);
        Save.add(load);
        Menu.setLayout(new FlowLayout());
        frame.setJMenuBar(Menu);
        GUIuser = new JPanel(new FlowLayout());
        GUIenemy = new JPanel(new FlowLayout());
        button = new JPanel (new FlowLayout());


        userL = new JLabel();
        enemyL = new JLabel();

        enemyImg = new ImageIcon("Images//orc.jpg");
        enemyL.setIcon(enemyImg);
        GUIenemy.add(enemyL);
        frame.add(GUIenemy);

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

        frame.setVisible(true);




    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }

        //if(e.getSource() == newCharacter){
        //User user = Character.createUser();
        //}

        if (e.getSource() == save) {
            System.out.println("save");
        }

        if (e.getSource() == load) {
            System.out.println("load");
        }

        if (e.getSource() == start) {
            if(users.isEmpty()) {
                User user = createUser();
            }
            User user = users.get(characterCount);

            Enemy enemy = createEnemy();
            battle(user,enemy);


            int decision = Integer.parseInt(JOptionPane.showInputDialog("Continue or give up? (1,2)"));
            while (decision != 2) {

                if (decision == 1) {
                    Enemy newEnemy = createEnemy();
                    battle(user, newEnemy);

                }
            }








        /*if(e.getSource() == attButton){
            userAttack();

        }

        if(e.getSource() == defButton){
            userDefend();
        }*/

        }
    }
    public void battle(User user, Enemy enemy) {

        double originalDef = user.getDef();
        double originalHp = user.getHp();

        String type = user.getType();
        if (type.equals("h")){
            userImg = new ImageIcon("Images//human.png");
            userL.setIcon(userImg);
            userL.setLocation(800,0);
            frame.add(userL);
        }
        else if (type.equals("e")){
            userImg = new ImageIcon("Images//elf.jpg");
            userL.setIcon(userImg);
            frame.add(userL);
        }
        else if(type.equals("d")){
            userImg = new ImageIcon("Images//dwarf.png");
            userL.setIcon(userImg);
            frame.add(userL);
        }
        else {
            userImg = new ImageIcon("Images//orc.jpg");
            userL.setIcon(userImg);
            frame.add(userL);
        }

        int userInitiation = 0;

        if (user.getAtt() > enemy.getAtt()) {
            userInitiation = 0;
        } else {
            userInitiation = 1;
        }
        String enemyType = enemy.getType();
        if(enemyType == "h") {
            enemyType = "Human";
            enemyImg = new ImageIcon("Images//human.png");
            enemyL.setIcon(enemyImg);
            frame.add(enemyL);
        }
        else if(enemyType =="e") {
            enemyType = "Elf";
            enemyImg = new ImageIcon("Images//elf.jpg");
            enemyL.setIcon(enemyImg);
            frame.add(enemyL);
        }
        else if (enemyType =="d") {
            enemyType = "Dwarf";
            enemyImg = new ImageIcon("Images//dwarf.png");
            enemyL.setIcon(enemyImg);
            frame.add(enemyL);
        }
        else {
            enemyType = "Orc";
            enemyImg = new ImageIcon("Images//orc.jpg");
            enemyL.setIcon(enemyImg);
            frame.add(enemyL);
        }
        JOptionPane.showMessageDialog(null,"You are fighting a " + enemyType);

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

        if(enemy.getHp()<=0){
            JOptionPane.showMessageDialog(null,"You win");
            user.setExp(user.getExp() + 50);
        }
        else
            JOptionPane.showMessageDialog(null,"You lose");

        JOptionPane.showMessageDialog(null,"The battle is over");

        user.setDef(originalDef);
        user.setHp(originalHp);

        JOptionPane.showMessageDialog(null, "Your stats are: \nAttack: " +user.getAtt() +
                "\nDefense: " + user.getDef() + "\nHit Points: " + user.getHp() + "\nExperience Points: " + user.getExp());
        checkExp(user);


    }

    public void UserTurn(User user, Enemy enemy){
        int nextMove = Integer.parseInt(JOptionPane.showInputDialog("USER 1 att, 2 def, 3 pass\n Your stats are: \nAttack: "+ user.getAtt() + "\nDefense: " + user.getDef() + "\nHp" + user.getHp()));
        if (nextMove == 1){
            userAttack(user,enemy);
        }
        if(nextMove==2){
            userDefend(user);
        }
        else
            return;
    }

    public void EnemyTurn(User user, Enemy enemy){
        JOptionPane.showMessageDialog(null,"Enemy's turn\nEnemy's Stats: " +
                "\nAttack: " +enemy.getAtt() + "\nDefense: " + enemy.getDef() + "\nHit Points: " + enemy.getHp());
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

    public void userDefend(User user){
        double originalDef = user.getDef();
        user.setDef(user.getDef()+10);
        JOptionPane.showMessageDialog(null,"Your def is now " + user.getDef());
    }
    public void enemyDefend(Enemy enemy){enemy.setDef(enemy.getDef()+10);}

    public void checkExp(User user){
        if (user.getExp() == 100){
            int choice = Integer.parseInt(JOptionPane.showInputDialog("You've leveled up. Select a stat to increase (1 att, 2 def, 3 hp)"));
            if (choice == 1){
                user.setAtt(user.getAtt() + 10);
            }
            else if (choice == 2){
                user.setDef(user.getDef() +10);
            }
            else
                user.setHp(user.getHp() + 10);

            user.setExp(0);

        }
    }

    public static User createUser() {

        String type = JOptionPane.showInputDialog("Please enter your character's race: (h:human, e:elf, d:dwarf, o:orc)");
        while (!type.equals("h") && !type.equals("e") && !type.equals("d") && !type.equals("o")) {
            type = JOptionPane.showInputDialog("Invalid choice, please pick again: (h:human, e:elf, d:dwarf, o:orc)");
        }

        User user = new User(type);
        characterCount++;
        users.add(user);
        return user;


    }

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
