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

    public boolean move(Rectangle rectangle) {

        Iterator<Enemy> itr = Enemy.enemies.iterator();

        if (this.y  == 700) {
//            enemies.remove(this);

            return false;
        }
        if (collision(rectangle)) {
            System.out.println("collosion");
            System.exit(ABORT);
        }


        y +=1;

        return true;
    }


    public static void paint(Graphics2D g) {
        Iterator<Enemy> itr = Enemy.enemies.iterator();
        //        System.out.println(Enemy.enemies);

        while (itr.hasNext()) {

            Enemy enemy = itr.next();

            g.fillOval(enemy.x, enemy.y, DIAMETER, DIAMETER);

        }
    }

    private boolean collision(Rectangle sprite) {
        return sprite.intersects(getEnemyBounds());
    }


    public Rectangle getEnemyBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
