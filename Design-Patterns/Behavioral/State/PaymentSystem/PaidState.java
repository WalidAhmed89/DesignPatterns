package Behavioral.State.PaymentSystem;

public class PaidState implements PaymentState{
    @Override
    public void pay(Payment payment) {
        System.out.println("Payment has already been paid.");
    }

    @Override
    public void ship(Payment payment) {
        System.out.println("Payment Shipped");
        payment.setState(new ShippedState());
    }

    @Override
    public void complete(Payment payment) {
        System.out.println("Cannot complete. Payment has not been shipped.");
    }
}
