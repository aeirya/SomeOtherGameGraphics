package ui.elements;

import engine.CellState;
import model.CellType;
import ui.IRenderer;
import ui.Layout;
import ui.std.Dimension;
import ui.std.Drawable;
import ui.std.Point;

public class GroundView implements Drawable {

    private final Layout layout;
    private final int HOR_N;
    private final int VER_N;
    private final CellState[][] cellStates;

    public GroundView(CellState[][] cellStates, Layout layout) {
        this.cellStates = cellStates;
        this.layout = layout;
        this.HOR_N = layout.horizontal_n;
        this.VER_N = layout.vertical_n;
    }

    private CellState[][] getCells() {
        return cellStates;
    }

    private CellState getCell(int i, int j) {
        return getCells()[i][j];
    }

    @Override
    public void draw(IRenderer r) {
        drawBoard(r);
        for (int i = 0; i < HOR_N; i++) {
            for (int j = 0; j < VER_N; j++) {
                final CellState cell = getCell(i, j);
                toCellView(cell, i, j, layout).draw(r);
            }
        }
    }

    private CellView toCellView(CellState cell, int x, int y, Layout layout) {
        if(identiyType(cell) == CellType.CHARACTER ) {
            return new CharacterView(cell, x, y, layout);
        }
        else {
            return new CellView(cell, x, y, layout);
        }
    }

    public CellType identiyType(CellState cell) {
        return cell.type;
    }

    private void drawBoard(IRenderer r) {
        final Dimension bs = layout.getBoardSize();
        final Point loc = layout.getBoardLocation();
        r.setColor(1f, 1f, 1f);
        r.fillRect(loc.x, loc.y, bs.width, bs.height);
    }
}