package ui.model;

public class Character {
    private Direction dir;
    private final boolean isEnemy;
    private int x;
    private int y;

    public Character() {
        dir = Direction.LEFT;
        x = 2;
        y = 2;
        isEnemy = false;
    }

    public Direction getDirection() {
        return dir;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}