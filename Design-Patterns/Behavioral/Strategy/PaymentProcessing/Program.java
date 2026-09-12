package Behavioral.Strategy.PaymentProcessing;

public class Program {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.setStrategy(new CreditCardPayment());
        paymentProcessor.processPayment(100);

        paymentProcessor.setStrategy(new PayPalStrategy());
        paymentProcessor.processPayment(250);

        paymentProcessor.setStrategy(new BankTransferPayment());
        paymentProcessor.processPayment(500);
    }
}
