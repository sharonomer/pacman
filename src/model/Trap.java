package model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * In level 4 there is a trap that appear close to the pacman position
 * and change its position every 5 seconds.
 * A collision of the pacman with the trap will cost 1 life
 */
public class Trap  extends Food{


    public Image tImage;


    public Trap(int x, int y) {
        super(x, y);

        try {
                tImage = ImageIO.read(this.getClass().getResource("/resources/images/ghost/blue/1.png"));
        } catch (IOException e) {
            System.err.println("Cannot Read Images !");
        }


    }

    public Image gettImage() {
        return tImage;
    }




}
