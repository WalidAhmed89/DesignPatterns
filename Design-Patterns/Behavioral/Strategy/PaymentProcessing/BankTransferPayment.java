package Behavioral.Strategy.PaymentProcessing;

public class BankTransferPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Processing bank transfer: $"+amount);
    }
}
