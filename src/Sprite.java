/**
 * Created by svindler on 02.11.2016.
 */
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Sprite {

    int x = 0;
    int y = 0;
    int xa = 0;
    int ya = 0;

    private Game game;

    public Sprite(Game game) {

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

    public void paint(Graphics2D g) {

        g.fillRect(x, y, 60, 60);

    }

    public void keyReleased(KeyEvent e) {

        ya = 0;
        xa = 0;

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
