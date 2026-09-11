package Behavioral.State.PaymentSystem;

public class Program {
    public static void main(String[] args) {
        Payment payment = new Payment();

        payment.ship();
        payment.pay();
        payment.pay();
        payment.ship();
        payment.complete();
        payment.complete();
    }
}
