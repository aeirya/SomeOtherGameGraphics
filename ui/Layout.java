package ui;

import ui.std.Dimension;
import ui.std.Point;

public class Layout {
    private final Dimension boardSize;
    private final Point boardLocation;
    private final Dimension healthSize;
    private final Point healthLocation;
    public final int vertical_n;
    public final int horizontal_n;

    public Layout() {
        boardSize = new Dimension(0.8f, 0.6f);
        boardLocation = new Point(0.1f, 0.3f);
        healthLocation = new Point(0.7f, 0.1f);
        healthSize = new Dimension(0.1f, 0.13f);
        vertical_n = 4;
        horizontal_n = 8;
    }

    public Dimension getBoardSize() {
        return boardSize;
    }

    public Point getBoardLocation() {
        return boardLocation;
    }

    public Point getHealthLocation() {
        return healthLocation;
    }

    public Dimension getHealthSize() {
        return healthSize;
    }

    public Dimension getCellSize() {
        return new Dimension(
            getBoardSize().width / horizontal_n,
            getBoardSize().height / vertical_n);
    }
}