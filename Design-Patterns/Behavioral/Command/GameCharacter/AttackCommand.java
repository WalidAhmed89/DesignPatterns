package Behavioral.Command.GameCharacter;

public class AttackCommand implements Command{
    private final GameCharacter gameCharacter;

    public AttackCommand(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    @Override
    public void execute() {
        gameCharacter.attack();
    }
}
