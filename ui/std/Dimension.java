package ui.std;

public class Dimension {

    public final float width;
    public final float height;

    public Dimension(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public Dimension scale(float ratio) {
        return new Dimension(width * ratio, height * ratio);
    }
}