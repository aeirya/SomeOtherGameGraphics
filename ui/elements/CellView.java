package ui.elements;

import engine.CellState;
import model.CellType;
import ui.IRenderer;
import ui.resource.ImageAsset;
import ui.resource.ResourceManager;
import ui.Layout;
import ui.std.Dimension;
import ui.std.Drawable;

public class CellView implements Drawable {

    protected final int x;
    protected final int y;
    protected final CellState cell;
    private final CellType type;
    private final Layout layout;
    private final int HOR_N;
    private final int VER_N;

    public CellView(CellState cell, int x, int y, Layout layout) {
        this.cell = cell;
        this.HOR_N = layout.horizontal_n;
        this.VER_N = layout.vertical_n;
        this.x = x;
        this.y = y;
        this.layout = layout;
        type = identiyType();
    }

    public CellType identiyType() {
        return cell.type;
    }

    public void draw(IRenderer r) {
        switch(type) {
            default:
            case EMPTY:
            drawNormalCell(r);
            break;
            case HEALTH:
            drawLifeCell(r);
            break;
            case CHARACTER:
            drawCharacterCell(r);
            break;
            case BLOCK:
            drawBlock(r);
            break;
        }
        drawBorder(r);
    }

    private Dimension getSize() {
        return layout.getCellSize();
    }

    public float getX() {
        return layout.getBoardLocation().x + (float) x / HOR_N * layout.getBoardSize().width;
    }

    public float getY() {
        return layout.getBoardLocation().y + (float) y / VER_N * layout.getBoardSize().height;
    }

    private float getWidth() {
        return getSize().width;
    }

    private float getHeight() {
        return getSize().height;
    }

    private void drawNormalCell(IRenderer r) {
        r.setColor(0.4f, 0.4f, 0.4f);
        drawImage(r, ImageAsset.GRASS);
    }

    protected void drawImage(IRenderer r, ImageAsset asset) {
        r.drawImage(ResourceManager.getAsset(asset), getX(), getY(), getWidth(), getHeight());
    }
    
    private void drawLifeCell(IRenderer r) {
        drawImage(r, ImageAsset.HEALTH);
    }

    private void drawCharacterCell(IRenderer r) {
        new CharacterView(
            cell, x, y, layout
        ).draw(r);
    }

    private void drawBlock(IRenderer r) {
        r.setColor(0.2f, 0.2f, 0.2f);
        drawImage(r, ImageAsset.BLOCK);
    }

    @Deprecated
    private void drawCell(IRenderer r) {
        r.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    private void drawBorder(IRenderer r) {
        r.setColor(1.0f, 0.5f, 0.5f);
        r.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}