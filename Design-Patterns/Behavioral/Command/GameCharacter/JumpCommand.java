package Behavioral.Command.GameCharacter;

public class JumpCommand implements Command{
   private final GameCharacter gameCharacter;

    public JumpCommand(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }


    @Override
    public void execute() {
        gameCharacter.jump();
    }
}
