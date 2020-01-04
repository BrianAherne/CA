package CA;

import javax.swing.*;
//running the program through the GUI class
public class Driver implements DEFObserver, HPObserver, ATKObserver {
    public static void main(String[] args) {
        //GUI test = new GUI();
        Character dwarf = new Dwarf();
        int test = dwarf.performAttack();
        dwarf.setAtt(test);
        int defend = dwarf.performDefend();
        System.out.println("def=" + defend + " att=" + test);
        dwarf.setAttackBehavior(new GreatAxeAttack());
        dwarf.setDefendBehavior((new AgileDefend()));
        test = dwarf.performAttack();
        defend = dwarf.performDefend();
        System.out.println("def=" + defend + " att=" + test);

    }

    @java.lang.Override
    public void updateATK() {

    }

    @java.lang.Override
    public void updateDEF() {

    }

    @java.lang.Override
    public void updateHP() {

    }
}
