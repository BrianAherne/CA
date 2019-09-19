package CA;

import javax.swing.*;
//running the program through the GUI class
public class Driver {
    public static void main(String[] args) {
        //GUI test = new GUI();
        Character dwarf = new Dwarf();
        int test = dwarf.performAttack();
        dwarf.setAtt(test);
        int defend = dwarf.performDefend();
        System.out.println("def=" + defend + " att=" + test);

    }
}
