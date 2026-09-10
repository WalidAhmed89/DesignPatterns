package Behavioral.Memento.Game;

public class Player {
    private int level;
    private int health;
    private int score;


    public Player(int level, int health, int score) {
        this.level = level;
        this.health = health;
        this.score = score;
    }

    public void play(){
        level++;
        health -= 20;
        score += 100;

        System.out.println("Player played!");
    }

    public Memento save(){
        return new Memento(this.level,this.health,this.score);
    }

    public void restore(Memento memento){
        this.level = memento.getLevel();
        this.health = memento.getHealth();
        this.score = memento.getScore();
    }

    public void showState(){
        System.out.println("Level: "+this.level+"\nHealth: "+this.health+"\nScore: "+this.score);
    }
}
