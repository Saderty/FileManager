package Arena;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Arena extends JFrame {
    private int x;
    private int y;

    Enemy enemy = new Enemy();

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
            setPreferredSize(new Dimension(505, 505));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawMatrix(g);
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 50, 50);

            enemy.move();
            enemy.draw(g);

            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void drawMatrix(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(2, 2, 500, 500);

        for (int i = 0; i < 10; i++) {
            g.drawLine(0, i * 50, 500, i * 50);
            g.drawLine(i * 50, 0, i * 50, 500);
        }
    }

    private void mp(MouseEvent e) {
        // x += 20;
        // y += 20;
        System.out.println(e.getX() + " " + e.getY());
    }

    private void kp(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (y != 0) {
                y -= 50;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (y != 450) {
                y += 50;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (x != 0) {
                x -= 50;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (x != 450) {
                x += 50;
            }
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
