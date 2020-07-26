package ui.elements;

import engine.CellState;
import ui.IRenderer;
import ui.Layout;
import model.util.Direction;
import ui.resource.ImageAsset;

public class CharacterView extends CellView {

    private final int character;

    public CharacterView(CellState cell, int x, int y, Layout layout) {
        super(cell, x, y, layout);
        this.character = cell.playerNumber;
    }

    private boolean isEnemy() {
        // use character number to get state?
        return false;
    }

    private ImageAsset getImage() {
        final Direction dir = cell.dir;
        if (!isEnemy()) {
            switch(dir) {
                default:
                case UP:
                return ImageAsset.PLAYER_UP;
                case DOWN:
                return ImageAsset.PLAYER_DOWN;
                case LEFT:
                return ImageAsset.PLAYER_LEFT;
                case RIGHT:
                return ImageAsset.PLAYER_RIGHT;
            }
        }
        else {
            return ImageAsset.ENEMY_DOWN;
        }
    }

    @Override
    public void draw(IRenderer r) {
        drawImage(r, getImage());
    }
}