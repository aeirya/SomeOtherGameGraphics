package ui;

import java.awt.Image;

public interface IRenderer {
    void setColor(float r, float g, float b);
    void drawBox(float x, float y, float size);
    void drawRect(float x, float y, float width, float height);
    void fillRect(float x, float y, float width, float height);
    void drawImage(Image image, float x, float y, float height, float width);
}