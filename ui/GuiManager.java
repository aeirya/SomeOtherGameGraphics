package ui;

import engine.CellState;
import ui.elements.GroundView;

public class GuiManager {

    private final GameGraphics graphics;
    private final FramerateTimer timer;
    private final Layout layout;
    private final Ui ui;
    private GroundView state;

    public GuiManager(GameGraphics graphics) {
        this.graphics = graphics;
        timer = new FramerateTimer(this);
        layout = new Layout();
        ui = new Ui(layout);
    }

    public void start() {
        timer.start();
    }

    public void update() {
        graphics.upload(state);
        graphics.upload(ui);
        graphics.update();
    }

    public void updateState(CellState[][] state) {
        final GroundView view = new GroundView(state, layout);  
        this.state = view;
    }
}