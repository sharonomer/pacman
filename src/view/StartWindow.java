package view;

import misc.Instructions;
import misc.MapEditor;
import view.FancyButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import misc.Instructions;

public class StartWindow extends JFrame {

    public StartWindow(){
        setSize(600,400);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon();
        try {
            logo = new ImageIcon(ImageIO.read(this.getClass().getResource("/resources/images/pacman_logo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  Register Custom fonts
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/resources/fonts/crackman.ttf")));
        } catch (IOException|FontFormatException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());
        getContentPane().add(new JLabel(logo),BorderLayout.NORTH);

        JPanel buttonsC = new JPanel();
        buttonsC.setBackground(Color.black);


        buttonsC.setLayout(new BoxLayout(buttonsC,BoxLayout.Y_AXIS));

        FancyButton startButton = new FancyButton("Start Game");
        FancyButton customButton = new FancyButton("Customize Game");
        FancyButton editButton = new FancyButton("Edit Questions");
        FancyButton highButton = new FancyButton("Highscores");
        FancyButton instButton = new FancyButton("Instructions");


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacWindow pw = new PacWindow();
                dispose();
            }
        });

        customButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapEditor me = new MapEditor();
                dispose();
            }
        });

        instButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instructions me = new Instructions();
                dispose();
            }
        });
        
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuestionScreen qs = new QuestionScreen();
                dispose();
            }
        });


        buttonsC.add(startButton);
        buttonsC.add(customButton);
        buttonsC.add(editButton);
        buttonsC.add(highButton);
        buttonsC.add(instButton);

        getContentPane().add(buttonsC);

        setVisible(true);
    }
}
