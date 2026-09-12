package Behavioral.TemplateMethod.OnlineOrderProcessing;

public class CreditCardOrder extends OrderProcessor{
    @Override
    protected void validateOrder() {
        System.out.println("Validating credit card order...");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing credit card payment...");
    }

    @Override
    protected void prepareShipment() {
        System.out.println("Preparing standard shipment...");
    }
}
