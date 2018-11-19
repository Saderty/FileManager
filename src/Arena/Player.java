package Arena;

import java.awt.*;

import static Arena.Arena.*;

class Player {
    private int x;
    private int y;


    Player() {
        x = 5;
        y = 5;
    }

    Player move(String direction) {
        switch (direction) {
            case UP:
                if (y != 0) y--;
                break;
            case DOWN:
                if (y != 9) y++;
                break;
            case LEFT:
                if (x != 0) x--;
                break;
            case RIGHT:
                if (x != 9) x++;
                break;
        }
        return this;
    }

    void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }
}
