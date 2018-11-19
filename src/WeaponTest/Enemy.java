package WeaponTest;

import java.awt.*;

class Enemy {
    private int weight = 50;

    private int x;
    private int y;

    Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, weight, weight);
    }

    int getX() {
        return x + weight / 2;
    }

    int getY() {
        return y + weight / 2;
    }

    void fire(Graphics g, Enemy enemy) {
        new Bullet(getX(), getY(), enemy.getX(), enemy.getY()).draw(g);
    }

    void line(Graphics g, Enemy enemy) {
        g.setColor(Color.RED);
        g.drawLine(getX(), getY(), enemy.getX(), enemy.getY());
    }
}
