package Behavioral.Observer.OrderNotficationSystem;

public interface Observer {
    void update(String orderId, String status,String customerName);
}
