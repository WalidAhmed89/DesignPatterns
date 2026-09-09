package Behavioral.Command.GameCharacter;

public class MoveCommand implements Command {
    private final GameCharacter moveCommand;
    private final String direcation;

    public MoveCommand(Behavioral.Command.GameCharacter.GameCharacter moveCommand, String direcation) {
        this.moveCommand = moveCommand;
        this.direcation = direcation;
    }


    @Override
    public void execute() {
        moveCommand.move(direcation);
    }
}
