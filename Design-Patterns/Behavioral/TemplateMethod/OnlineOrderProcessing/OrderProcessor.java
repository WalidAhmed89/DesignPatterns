package Behavioral.TemplateMethod.OnlineOrderProcessing;

abstract class OrderProcessor {

    public final void orderProcessor(){
        validateOrder();
        processPayment();
        prepareShipment();
        sendNotification();
    }

    protected abstract void validateOrder();
    protected abstract void processPayment();
    protected abstract void prepareShipment();

    protected void sendNotification(){
        System.out.println("Order notification sent.");
    }
}
