package ui;

public class FramerateTimer {

    private static final int FPS = 20;
    private final GuiManager gui;
    private boolean isRunning = true;

    public FramerateTimer(GuiManager gui) {
        this.gui = gui;
    }

    public void start() {
        new Thread(this::run).start();
    }

    private void run() {
        while (isRunning) {
            tick();
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000 / FPS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void tick() {
        gui.update();
    }

    public void stop() {
        isRunning = false;
    }
}