package ui.swing;

import java.awt.Graphics;

import ui.GameGraphics;
import ui.std.Drawable;

public class SwingGraphics implements GameGraphics {

    private final Screen screen;
    private final Renderer renderer;

    public SwingGraphics() {
        screen = new Screen(this);
        renderer = new Renderer(screen);
    }

    @Override
    public void start() {
        screen.show();
    }

    public void draw(Graphics g) {
        renderer.draw(g);
    }

    @Override
    public void update() {
        screen.update();
    }

    public void upload(Drawable drawable) {
        renderer.upload(drawable);
    }
}