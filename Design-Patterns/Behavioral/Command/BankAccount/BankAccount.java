package Behavioral.Command.BankAccount;

public class BankAccount {
    public void sendMoney(double amount){
        System.out.println("Sending $"+amount);
    }

    public void withdrawMoney(double amount){
        System.out.println("Withdraw $"+amount);
    }
}
