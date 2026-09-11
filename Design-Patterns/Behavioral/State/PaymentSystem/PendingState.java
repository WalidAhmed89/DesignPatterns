package Behavioral.State.PaymentSystem;

public class PendingState implements PaymentState{
    @Override
    public void pay(Payment payment) {
        System.out.println("Payment complete!");
        payment.setState(new PaidState());
    }

    @Override
    public void ship(Payment payment) {
        System.out.println("Cannot ship. Payment is still Pending!.");
    }

    @Override
    public void complete(Payment payment) {
        System.out.println("Cannot complete. Payment has not been shipped.");
    }
}
