package WeaponTest;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WeaponTest extends JFrame {
    Enemy enemy = new Enemy(250, 50);
    Enemy enemyQ = new Enemy(300, 300);

    public WeaponTest() {
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
            setPreferredSize(new Dimension(500, 500));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            repaint();

            enemy.draw(g);
            enemyQ.draw(g);
            enemy.line(g, enemyQ);
            // enemy.fire(g, enemyQ);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void mp(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
    }

    private void kp(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println(enemy.getX());
            System.out.println(enemy.getY());
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            enemy.fire(getGraphics(), enemyQ);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeaponTest().setVisible(true);
            }
        });
    }
}
