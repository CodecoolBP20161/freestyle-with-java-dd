import java.awt.Graphics;
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
    Enemy enemy = new Enemy();


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

        if (randomNum > 990) {
            Enemy enemy = new Enemy();
        }else{
//            System.out.println("most nincs enemy.");
        }
    }

    private void spriteMove() {

        sprite.move();

    }

    public void enemyMove() {
        Iterator<Enemy> itr = Enemy.enemies.iterator();
//        System.out.println(Enemy.enemies);

        while (itr.hasNext()) {

            Enemy enemy = itr.next();

            if(!enemy.move()){

                itr.remove();

            }
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        doDrawing(g);
//        Iterator<Enemy> itr = Enemy.enemies.iterator();
////        System.out.println(Enemy.enemies);
//
//        while (itr.hasNext()) {
//
//            Enemy enemy = itr.next();
//            enemy.paint(g2d);
//            System.out.println(enemy.x);
//
//
//
//        }
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

