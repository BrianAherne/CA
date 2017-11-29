package CA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by t00160248 on 29/11/2017.
 */
public class GUI extends JFrame implements ActionListener {
    private JMenu mainMenu, Save;
    private JMenuBar Menu;
    private JMenuItem save, load, exit;
    private JButton attButton, defButton;
    private JPanel user, enemy, button;
    private JFrame frame = new JFrame("RPG");

    public GUI(){
        frame.setLocation(100,0);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(3,2));
        save = new JMenuItem();
        load = new JMenuItem();
        exit = new JMenuItem();
        save.addActionListener(this);
        load.addActionListener(this);
        exit.addActionListener(this);
        mainMenu = new JMenu();
        Save = new JMenu();
        Menu = new JMenuBar();
        mainMenu.setText("Options");
        Save.setText("Save/Load");
        save.setText("Save");
        load.setText("Load");
        exit.setText("Exit");
        Menu.add(mainMenu);
        Menu.add(Save);
        mainMenu.add(exit);
        Save.add(save);
        Save.add(load);
        Menu.setLayout(new FlowLayout());
        frame.setJMenuBar(Menu);
        user = new JPanel(new FlowLayout());
        enemy = new JPanel(new FlowLayout());
        button = new JPanel (new FlowLayout());

        attButton = new JButton("Attack");
        defButton = new JButton("Defend");
        attButton.setSize(80,80);
        button.add(attButton);
        button.add(defButton);

        frame.add(user);
        frame.add(enemy);

        button.add(attButton);
        button.add(defButton);

        frame.add(button);
        attButton.addActionListener(this);
        defButton.addActionListener(this);




    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit){
            System.exit(0);
        }

        if(e.getSource() == save){
            System.out.println("save");
        }

        if(e.getSource() == load){
            System.out.println("load");
        }

        if(e.getSource() == attButton){
            System.out.println("attack");
        }

        if(e.getSource() == defButton){
            System.out.println("defend");
        }

    }

}
