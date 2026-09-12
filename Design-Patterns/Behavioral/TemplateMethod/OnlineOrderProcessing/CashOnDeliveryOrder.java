package Behavioral.TemplateMethod.OnlineOrderProcessing;

public class CashOnDeliveryOrder extends OrderProcessor {
    @Override
    protected void validateOrder() {
        System.out.println("Validating cash on delivery order...");
    }

    @Override
    protected void processPayment() {
        System.out.println("Payment will be collected on delivery.");
    }

    @Override
    protected void prepareShipment() {
        System.out.println("Preparing cash on delivery shipment...");
    }
}
