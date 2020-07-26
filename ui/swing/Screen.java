package ui.swing;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.std.Point;
import ui.std.Dimension;

public class Screen {
    private final JFrame frame;
    private final JPanel panel;

    public Screen(SwingGraphics graphics) {
        frame = new JFrame();
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                graphics.draw(g);
            }
            private static final long serialVersionUID = 1L;
        };

        this.setupFrame();
    }

    public void setupFrame() {
        this.setSize(
            new Dimension(1400, 800));
        this.setLocation(
            new Point(100, 100));
        frame.setContentPane(panel);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void setSize(Dimension size) {
        frame.setSize(
            new java.awt.Dimension((int)size.width, (int)size.height));
    }

    public Dimension getSize() {
        final java.awt.Dimension size = frame.getSize();
        return new Dimension(
            size.width, size.height);
    }

    public void setLocation(Point point) {
        frame.setLocation(
            new java.awt.Point((int) point.x, (int) point.y));
    }

    public void update() {
        frame.repaint();
        frame.revalidate();
    }
}