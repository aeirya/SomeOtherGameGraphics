package ui;

import ui.std.Drawable;

public interface GameGraphics {
    void start();
    void update();
    void upload(Drawable drawable);
}