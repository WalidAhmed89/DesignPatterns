package Behavioral.Memento.Game;

public class Memento {
    private final int level;
    private final int health;
    private final int score;


    public Memento(int level, int health, int score) {
        this.level = level;
        this.health = health;
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }
}
