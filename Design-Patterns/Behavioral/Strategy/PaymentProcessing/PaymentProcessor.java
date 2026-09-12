package Behavioral.Strategy.PaymentProcessing;

public class PaymentProcessor {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void processPayment(double amount){
        strategy.pay(amount);
    }
}
