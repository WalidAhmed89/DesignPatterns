package Behavioral.Command.GameCharacter;

public class GameCharacter {
    public void attack() {
        System.out.println("Character attacks!");
    }

    public void jump() {
        System.out.println("Character jumps!");
    }

    public void move(String direction) {
        System.out.println("Character move! "+direction);
    }
}
