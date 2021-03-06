package Arena;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test extends JFrame {
    private int x, y;

    private Test() {
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

            g.drawRect(x, y, 50 + x, 50 + y);
            repaint();
        }
    }

    private void mp(MouseEvent e) {
        x += 20;
        y += 20;
        System.out.println(e.getX() + " " + e.getY());
    }

    private void kp(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_W) {
            y -= 50;
            System.out.println("W");
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            y += 50;
            System.out.println("S");
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }
}
