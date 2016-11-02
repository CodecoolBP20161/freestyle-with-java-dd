/**
 * Created by svindler on 02.11.2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Image;


public class Sprite {

    int x = 0;
    int y = 0;
    int xa = 0;
    int ya = 0;

    private Game game;

    private Image image;

    public Sprite(Game game) {
        ImageIcon icon = new ImageIcon("src/sprite.png");
        image = icon.getImage();


        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth()-60) {

            x = x + xa;
        }

        if (y + ya > 0 && y + ya < game.getWidth()-60) {

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
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ya = 1;

        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            ya = -1;

        }
    }

}
