/**
 * Created by svindler on 03.11.2016.
 */


import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;


public class Enemy extends JPanel{

    private static final int DIAMETER = 30;


    private int x = (int)(Math.random() * 580 + 1);
    public static ArrayList<Enemy> enemies = new ArrayList<>();
    private int y = 0;


    public Enemy() {

        enemies.add(this);

    }

    public boolean move(Rectangle rectangle, Rectangle enemyRec) {

        Iterator<Enemy> itr = Enemy.enemies.iterator();

        if (this.y  == 700) {

            return false;
        }
        if (collision(rectangle, enemyRec)) {
            JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
            System.exit(ABORT);
        }


        y +=1;

        return true;
    }


    public static void paint(Graphics2D g) {
        Iterator<Enemy> itr = Enemy.enemies.iterator();

        while (itr.hasNext()) {

            Enemy enemy = itr.next();
            g.setColor(Color.yellow);
            g.fillOval(enemy.x, enemy.y, DIAMETER, DIAMETER);

        }
    }

    private boolean collision(Rectangle sprite, Rectangle enemyRec) {
        return sprite.intersects(enemyRec);
    }


    public Rectangle getEnemyBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
