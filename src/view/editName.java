package view;

import view.FancyButton;
import view.PacWindow;
import view.StartWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class editName extends JFrame {
          private JLabel title;
          public JTextField tname;

    public editName() {
        setSize(600, 400);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon();
        try {
            logo = new ImageIcon(ImageIO.read(this.getClass().getResource("/resources/images/pacman_logo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());
        getContentPane().add(new JLabel(logo),BorderLayout.NORTH);

        JPanel buttonsC = new JPanel();
        buttonsC.setBackground(Color.black);

        title = new JLabel("Please enter your name");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(500, 30);
        title.setLocation(145, 170);
        title.setForeground(Color.yellow);

        getContentPane().add(title);


        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(200, 20);
        tname.setLocation(200, 210);

        getContentPane().add(tname);

        buttonsC.setLayout(new BoxLayout(buttonsC,BoxLayout.LINE_AXIS));
        FancyButton startButton = new FancyButton("Start Game");
        FancyButton mainMenu = new FancyButton("Main Menu");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO add check to see if input is valid
                new PacWindow(tname.getText());
                dispose();
            }
        });

        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new StartWindow();
                    dispose();
            }
        });

        buttonsC.add(mainMenu);
        buttonsC.add(Box.createHorizontalGlue());
        buttonsC.add(startButton);

        getContentPane().add(buttonsC);
        setVisible(true);
    }
}
