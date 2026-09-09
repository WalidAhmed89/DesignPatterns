package Behavioral.Observer.OrderNotficationSystem;

public class DeliverySystem implements Observer{
    @Override
    public void update(String orderId, String status, String customerName) {
        if(status.equals("SHIPPED")) {
            System.out.println("Delivery System\n" + "Preparing delivery for Order #"+orderId);
            return;
        }
    }
}
