package ui;

import engine.CellState;
import ui.elements.GroundView;
import ui.std.Drawable;
import ui.swing.SwingGraphics;

public class Main implements Runnable {
    
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        final GameGraphics graphics = new SwingGraphics();
        final GuiManager gui = new GuiManager(graphics);
        graphics.start();
        gui.start();

        // try this to test 
        redesignTest(gui, null);
    }


    private void redesignTest(GuiManager gui, CellState[][] state) {
        gui.updateState(state);
    }
        // test2(gui);

        // int a = 0;
        // while(true) {
        //     if (a == 0) {
        //         a = 20;
        //     }
        //     test2();
        //     a -= 1;

        // }

    // public void test(GameGraphics graphics) {
    //     graphics.upload(
    //         sample()
    //     );
    // }

    // public void test2(GuiManager gui) {
    //     gui.updateState(
    //         new GameGround(8, 4)
    //     );
    // }

    // public Drawable sample() {
    //     return new GroundView(
    //         new GameGround(10, 5)    
    //     , new Layout());
    // }
}