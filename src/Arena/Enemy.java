package Arena;

import java.awt.*;
import java.util.Random;

import static Arena.Arena.cellSize;

class Enemy {
    private int x;
    private int y;

    Enemy() {
    }

    Enemy move() {
        int r = new Random().nextInt(4) + 1;
        if (r == 1 && y != 9) y++;
        if (r == 2 && x != 9) x++;
        if (r == 3 && y != 0) y--;
        if (r == 4 && x != 0) x--;

        return this;
    }

    void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }
}