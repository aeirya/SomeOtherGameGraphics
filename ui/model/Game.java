package ui.model;

public class Game {
    private Character player;
    private Character enemy;
    private Ground ground;

    public Game() {
        player = new Character();
        enemy = new Character();
        ground = new Ground();
    }

    public Character getPlayer() {
        return this.player;
    }

    public Character getEnemy() {
        return this.enemy;
    }

    public Ground getGround() {
        return this.ground;
    }

}