package WeaponTest;

import javax.swing.*;
import java.awt.*;

class Bullet {
    private int x;
    private int y;
    private int xEnd;
    private int yEnd;
    private int speed = 50;

    Bullet(int x, int y, int xEnd, int yEnd) {
        this.x = x;
        this.y = y;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    void draw(Graphics g) {
        g.setColor(Color.RED);
        Runnable r = () -> {
            try {
                while (xEnd - x > speed || yEnd - y > speed) {
                    g.fillRect(x, y, 10, 10);
                    x += (xEnd - x) * speed / (Math.sqrt(Math.pow(xEnd - x, 2) + Math.pow(yEnd - y, 2)));
                    y += (yEnd - y) * speed / (Math.sqrt(Math.pow(xEnd - x, 2) + Math.pow(yEnd - y, 2)));

                    Thread.sleep(100);
                }
            } catch (Exception e) {
            }
        };

        Thread thread = new Thread(r, "BulletThread");
        thread.start();
    }
}