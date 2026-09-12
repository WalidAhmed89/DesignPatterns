package Behavioral.Strategy.PaymentProcessing;

public class PayPalStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment: $"+amount);
    }
}
