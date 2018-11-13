package Arena;

import java.awt.*;
import java.util.Random;

class Enemy {
    private int x;
    private int y;
    private Random random = new Random();

    Enemy() {
    }

    void move() {
        int r = random.nextInt(3) + 1;
        if (r == 1 && y != 9) y++;
        if (r == 2 && x != 9) x++;
        if (r == 3 && y != 0) y--;
        if (r == 4 && y != 0) x--;
    }

    void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x * 50, y * 50, 50, 50);
    }
}
