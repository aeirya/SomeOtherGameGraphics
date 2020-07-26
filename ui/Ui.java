package ui;
import ui.resource.ImageAsset;
import ui.resource.ResourceManager;
import ui.std.Dimension;
import ui.std.Drawable;
import ui.std.Point;

public class Ui implements Drawable {

    private final Layout layout;

    public Ui(Layout layout) {
        this.layout = layout;
    }

    @Override
    public void draw(IRenderer g) {
        final Dimension dim = layout.getHealthSize();
        final Point pos = layout.getHealthLocation();
        g.drawImage(ResourceManager.getAsset(ImageAsset.HEART_UI), pos.x, pos.y, dim.width, dim.height);
    }  
}