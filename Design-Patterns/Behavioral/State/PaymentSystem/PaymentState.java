package Behavioral.State.PaymentSystem;

public interface PaymentState {
    void pay(Payment payment);
    void ship(Payment payment);
    void complete(Payment payment);
}
