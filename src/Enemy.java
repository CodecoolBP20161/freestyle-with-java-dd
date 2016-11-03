/**
 * Created by svindler on 03.11.2016.
 */


import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;


public class Enemy extends JPanel{

    private int x = (int)(Math.random() * 575 + 1);
    public static ArrayList<Enemy> enemies = new ArrayList<>();
    private int y = 0;


    public Enemy() {

        enemies.add(this);

    }

    public boolean move() {

        Iterator<Enemy> itr = Enemy.enemies.iterator();

        if (this.y  == 700) {
//            enemies.remove(this);

            return false;
        }

        y +=1;
        return true;
    }


    public static void paint(Graphics2D g) {
        Iterator<Enemy> itr = Enemy.enemies.iterator();
        //        System.out.println(Enemy.enemies);

        while (itr.hasNext()) {

            Enemy enemy = itr.next();

            g.fillOval(enemy.x, enemy.y, 30, 30);




        }
    }


}
