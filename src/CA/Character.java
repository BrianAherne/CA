package CA;

import javax.swing.*;

import java.io.Serializable;

import static javax.swing.JOptionPane.showMessageDialog;

public abstract class Character implements Serializable{
    private String type;
    private double hp, att, def, exp;
    AttackBehavior attackBehavior;
    DefendBehavior defendBehavior;

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

    public Integer performAttack(){
        //attack here
        int damage;
        damage = attackBehavior.attack();
        return damage;
    }

    public Integer performDefend(){
        //defend here
        int defend;
        defend = defendBehavior.defend();
        return defend;
    }

    public void setAttackBehavior(AttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    public void setDefendBehavior(DefendBehavior defendBehavior) {
        this.defendBehavior = defendBehavior;
    }

    @Override
    public String toString() {
        String type;
        String fullType="";
        type = getType();
        if(type.equals("h"))
            fullType = "Human";
        if(type.equals("e"))
            fullType = "Elf";
        if(type.equals("d"))
            fullType = "Dwarf";
        if(type.equals("o"))
            fullType = "Orc";
        String details = ("Character type: " + fullType + "\nAttack: " + getAtt() + "\nDefense" + getDef() + "\nHit Points" + getHp());
        return details;
    }
}


