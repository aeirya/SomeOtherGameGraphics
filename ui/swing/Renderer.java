package ui.swing;

import java.awt.Color;
import java.awt.Graphics;

import ui.DrawBuffer;
import ui.IRenderer;
import ui.std.Drawable;

import java.awt.Image;

public class Renderer implements IRenderer {

    private final Screen screen;
    private final DrawBuffer drawables;
    private Graphics g;

    public Renderer(Screen screen) {
        this.screen = screen;
        drawables = new DrawBuffer();
    }

	public void upload(Drawable drawable) {
        drawables.add(drawable);
    }

    public synchronized void draw(Graphics g) {
        this.g = g;
        for (Drawable d : drawables.get()) {
            d.draw(this);
        }
    }

    public int x(float x) {
        return (int) (x * screen.getSize().width);
    }
    
    public int y(float y) {
        return (int) (y * screen.getSize().height);
    }

    public void drawBox(float x, float y, float size) {
        g.fillRect(x(x), y(y), y(size), y(size));
    }

    public void drawRect(float x, float y, float width, float height) {
        g.drawRect(x(x), y(y), x(width), y(height));
    }

    public void fillRect(float x, float y, float width, float height) {
        g.fillRect(x(x), y(y), x(width), y(height));
    }

    public void setColor(float r, float g, float b) {
        this.g.setColor(new Color(r,g,b));
    }

    public void drawImage(Image image, float x, float y, float width, float height, ui.std.Color c) {
        this.g.drawImage(image, x(x), y(y), x(width), y(height), new Color(c.r,c.g,c.b),null);
    }
    
    public void drawImage(Image image, float x, float y, float width, float height) {
        this.g.drawImage(image, x(x), y(y), x(width), y(height) ,null);
    }
}