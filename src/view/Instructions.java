package view;

import view.FancyButton;
import view.StartWindow;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JFrame {

    public Instructions(){
        setSize(650,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BorderLayout());
        sideBar.setBackground(Color.black);

        setLayout(new BorderLayout());
        getContentPane().add(sideBar,BorderLayout.EAST);


        JTextArea ta = new JTextArea();
        ta.setBackground(Color.black);
        ta.setForeground(Color.yellow);
        ta.setText("Pac-Man is an action maze chase video game; the player controls the eponymous character \n" +
                "through an enclosed maze. The objective of the game is to eat all of the dots placed in the \n" +
                "maze while avoiding four colored ghosts — Blinky (red), Pinky (pink), Inky (cyan), and Clyde (orange)\n" +
                " — that pursue him. When Pac-Man eats all of the dots, the player advances to the next level. \n" +
                "If Pac-Man makes contact with a ghost, he will lose a life; the game ends when all lives are lost. \n" +
                "Each of the four ghosts have their own unique, distinct artificial intelligence; Blinky gives direct chase\n" +
                " to Pac-Man, Pinky and Inky try to position themselves in front of Pac-Man, usually by cornering him,\n" +
                " and Clyde will switch between chasing Pac-Man and fleeing from him.");

        ta.setBorder(new CompoundBorder(new CompoundBorder(new EmptyBorder(20,10,20,10),new LineBorder(Color.yellow)),new EmptyBorder(10,10,10,10)));
        getContentPane().add(ta);

        FancyButton backButton = new FancyButton("Back", 20f);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartWindow();
                dispose();
            }
        });
        sideBar.add(backButton,BorderLayout.SOUTH);

        setVisible(true);

    }
}
