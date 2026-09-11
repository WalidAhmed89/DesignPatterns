package Behavioral.State.PaymentSystem;

public class CompleteState implements PaymentState{
    @Override
    public void pay(Payment payment) {
        System.out.println("Payment has already been paid.");
    }

    @Override
    public void ship(Payment payment) {
        System.out.println("Payment has already been shipped.");
    }

    @Override
    public void complete(Payment payment) {
        System.out.println("Payment has already been complete.");
    }
}
