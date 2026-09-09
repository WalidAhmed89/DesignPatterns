package Behavioral.Observer.OrderNotficationSystem;

public class CustomerNotification implements Observer{


    @Override
    public void update(String orderId, String status,String customerName) {
        System.out.println("Customer "+customerName+" notified: \n"+"Order #"+orderId+"is now "+status);
    }
}
