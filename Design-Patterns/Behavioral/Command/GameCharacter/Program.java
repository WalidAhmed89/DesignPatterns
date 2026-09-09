package Behavioral.Command.GameCharacter;

public class Program {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter();

        MoveCommand moveCommand = new MoveCommand(character,"strait");
        JumpCommand jumpCommand = new JumpCommand(character);
        AttackCommand attackCommand = new AttackCommand(character);

        GameController controller = new GameController();

        controller.setCommand(moveCommand);
        controller.pressButton();

        controller.setCommand(jumpCommand);
        controller.pressButton();

        controller.setCommand(attackCommand);
        controller.pressButton();
    }
}
