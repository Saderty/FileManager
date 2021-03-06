package Arena;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Arena extends JFrame {
    final static String UP = "UP";
    final static String DOWN = "DOWN";
    final static String LEFT = "LEFT";
    final static String RIGHT = "RIGHT";

    final static int cellSize = 50;
    final static int cellNumber = 10;

    private Player player = new Player();
    private Enemy enemy = new Enemy();
    private Enemy enemy1 = new Enemy();

    private Arena() {
        JPanel panel = new Panel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                kp(e);
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mp(e);
            }
        });

        panel.setFocusable(true);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    class Panel extends JPanel {
        Panel() {
            setPreferredSize(new Dimension(cellNumber * cellSize + 5, cellNumber * cellSize + 5));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawMatrix(g);

            player.draw(g);
            enemy.move().draw(g);
            enemy1.move().draw(g);

            //repaint();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void drawMatrix(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(2, 2, cellNumber * cellSize, cellNumber * cellSize);

        for (int i = 0; i < cellNumber; i++) {
            g.drawLine(0, i * cellSize, cellNumber * cellSize, i * cellSize);
            g.drawLine(i * cellSize, 0, i * cellSize, cellNumber * cellSize);
        }
    }

    private void mp(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
    }

    private void kp(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.move(UP);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.move(DOWN);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.move(LEFT);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.move(RIGHT);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arena().setVisible(true);
            }
        });
    }
}
