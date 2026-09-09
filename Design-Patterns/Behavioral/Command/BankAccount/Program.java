package Behavioral.Command.BankAccount;

public class Program {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        SendMoneyCommand sendMoneyCommand = new SendMoneyCommand(account,5000);
        WithdrawCommand withdrawCommand = new WithdrawCommand(account,4000);

        TransactionButton transactionButton = new TransactionButton();
        transactionButton.setCommand(sendMoneyCommand);
        transactionButton.click();
        transactionButton.setCommand(withdrawCommand);
        transactionButton.click();
    }
}
