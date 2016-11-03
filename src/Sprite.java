/**
 * Created by svindler on 02.11.2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Image;


public class Sprite {

    int x = 240;
    int y = 500;
    int xa = 0;
    int ya = 0;


    private Image image;

    public Sprite() {
        ImageIcon icon = new ImageIcon("src/sprite.png");
        image = icon.getImage();


    }

    public void move() {
        if (x + xa > 0 && x + xa < 600-60) {

            x = x + xa;
        }

        if (y + ya > 0 && y + ya < 700-60) {

            y = y + ya;

        }
    }

    public Image getImage() {
        return image;
    }

    public void keyReleased(KeyEvent e) {

        ya = 0;
        xa = 0;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            xa = -1;
        }

        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 1;
        }

    }

}
