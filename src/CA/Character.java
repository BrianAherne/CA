package CA;

import javax.swing.*;

public class Character {
    private String type;
    private double hp, att, def, exp;

    public String getType() {
        return type;
    }

    public double getAtt() {
        return att;
    }

    public double getDef() {
        return def;
    }

    public double getHp() {
        return hp;
    }

    public double getExp() { return exp; }

    public void setType(String type) {
        this.type = type;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public void setAtt(double att) {
        this.att = att;
    }

    public void setExp(double exp) { this.exp = exp; }

    public void battle(User user, Enemy enemy) {

        double originalDef = user.getDef();
        double originalHp = user.getHp();

        int userInitiation = 0;

        if (user.getAtt() > enemy.getAtt()) {
            userInitiation = 0;
        } else {
            userInitiation = 1;
        }
        String enemyType = enemy.getType();
        if(enemyType == "h")
            enemyType ="Human";
        else if(enemyType =="e")
            enemyType ="Elf";
        else if (enemyType =="d")
            enemyType ="Dwarf";
        else
            enemyType ="Orc";

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
            user.setExp(exp + 50);
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
            enemy.enemyAttack(enemy, user);
        }
        if (enemyMove>0.5){
            enemy.enemyDefend(enemy);
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
            int choice = Integer.parseInt(JOptionPane.showInputDialog("You've leveled up. Select a stat to increase (1 att, 2 def, 3 hp"));
            if (choice == 1){
                user.setAtt(att + 10);
            }
            else if (choice == 2){
                user.setDef(def+10);
            }
            else
                user.setHp(hp + 10);

            user.setExp(0);

        }
    }



}

