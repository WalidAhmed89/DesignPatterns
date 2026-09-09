package Behavioral.Observer.OrderNotficationSystem;

public class Program {
    public static void main(String[] args) {
        //CREATING THE OBSERVABLE
        Order order = new Order("1001", "Walid", "PLACED");

        //CREATING THE OBSERVERS
        CustomerNotification customerNotification = new CustomerNotification();
        InventorySystem inventorySystem = new InventorySystem();
        DeliverySystem deliverySystem = new DeliverySystem();

        //ADDING THE OBSERVERS INTO THE OBSERVABLE
        order.addObserver(customerNotification);
        order.addObserver(inventorySystem);
        order.addObserver(deliverySystem);

        //TEST
        order.setStatus("SHIPPED");
    }
}
