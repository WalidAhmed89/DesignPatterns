package Behavioral.Observer.OrderNotficationSystem;

public class InventorySystem implements Observer{

    @Override
    public void update(String orderId, String status, String customerName) {
        System.out.println("Inventory System:\n"+"Updating inventory for Order #"+orderId);
    }
}
