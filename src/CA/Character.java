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


}


