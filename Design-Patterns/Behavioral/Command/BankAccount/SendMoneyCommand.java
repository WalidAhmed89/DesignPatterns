package Behavioral.Command.BankAccount;

public class SendMoneyCommand implements Command {
    private final BankAccount account;
    private final double amount;

    public SendMoneyCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.sendMoney(amount);
    }
}
