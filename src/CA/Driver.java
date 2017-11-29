package CA;

import javax.swing.*;

public class Driver {
    public static void main(String[] args) {
        GUI test = new GUI();
        /*String type = JOptionPane.showInputDialog("Please enter your character's race: (h:human, e:elf, d:dwarf, o:orc");
        while (!type.equals("h") && !type.equals("e") && !type.equals("d") && !type.equals("o") ){
            type = JOptionPane.showInputDialog("Invalid choice, please pick again: (h:human, e:elf, d:dwarf, o:orc");
        }

        User user = new User(type);

        int decision = Integer.parseInt(JOptionPane.showInputDialog("Character created! Begin or quit? (1, 2"));

        while (decision != 2) {

            if (decision == 1) {
                String enemyType = "";
                double eType = Math.random();
                if (eType <0.25)
                    enemyType = "h";
                else if (eType >0.25 && eType <0.5)
                    enemyType = "e";
                else if (eType >0.5 && eType < 0.75)
                    enemyType = "d";
                else
                    enemyType = "o";
                Enemy enemy = new Enemy(enemyType);//randomise
                user.battle(user, enemy);

                decision = Integer.parseInt(JOptionPane.showInputDialog("1 to continue, 2 to quit"));


            }
        }*/

    }
}
