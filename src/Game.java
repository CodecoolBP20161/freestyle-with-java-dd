import java.awt.*;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel {

    Sprite sprite = new Sprite();


    private Game() {


        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                sprite.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {

                sprite.keyPressed(e);
            }
        });

        setFocusable(true);
    }

    private void createEnemy() {
        int randomNum = (int)(Math.random() * 1000 + 1);

        if (randomNum > 995) {
            Enemy enemy = new Enemy();
        }else{
        }
    }

    private void spriteMove() {

        sprite.move();

    }

    public void enemyMove() {
        Iterator<Enemy> itr = Enemy.enemies.iterator();
        Rectangle rec = sprite.getSpriteBounds();

        while (itr.hasNext()) {

            Enemy enemy = itr.next();

            if(!enemy.move(rec)){

                itr.remove();

            }
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        doDrawing(g);
        Enemy.paint(g2d);

    }

    public void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), this);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Boring Game");

        Game game = new Game();
        frame.add(game);
        game.setBackground(Color.black);
        frame.setSize(600, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.createEnemy();
            game.spriteMove();
            game.enemyMove();
            game.repaint();
            Thread.sleep(10);
        }
    }
}

