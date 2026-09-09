package Behavioral.Command.BankAccount;

public class TransactionButton {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void click(){
        command.execute();
    }
}
